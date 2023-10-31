package com.example.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class LearnDecisionMaking extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("timer:decisionMaking?period=5000")

                .log("Headers <=========> ${headers}")

                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {

                        exchange.getMessage().setHeader("role","developer");

                    }
                })

                .log("Headers <=========> ${headers}")

                .choice()


                .when(header("role").contains("developer")).to("direct:developer")

                .when(header("department").contains("hr")).to("direct:hr")

                .otherwise().to("direct:dummy")

                .endChoice();

                from("direct:developer")
                        .process(new Processor() {
                            @Override
                            public void process(Exchange exchange) throws Exception {

                                System.out.println("Calling Developer Route");

                                exchange.getMessage().setBody("Hi Developer");
                            }
                        })
                        .to("log:?level=INFO&showBody=true");




    }
}
