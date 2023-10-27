package com.example.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


//@Component
public class LearnConsumerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("timer:callApi?period=10000")

                .log("Rest Api Calling ...")

                .setHeader(Exchange.HTTP_METHOD,simple("GET"))

                .to("http://localhost:9090/showTicket")

                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {

                        System.out.println("Payload " +exchange);

                        String response = exchange.getIn().getBody(String.class);

                        System.out.println("Message "+exchange.getIn());

                        System.out.println("Message out"+exchange.getIn().toString());

                        System.out.println(exchange.getAllProperties());

                        System.out.println("uri"+exchange.getFromEndpoint().getEndpointBaseUri());

                        System.out.println("message  "+exchange.getMessage().getBody());
//                        System.out.println(exchange.getMessage());

                        System.out.println("Response "+response);

                    }
                });

    }
}
