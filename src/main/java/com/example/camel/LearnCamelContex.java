package com.example.camel;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class LearnCamelContex {

    public static void main(String[] args) throws Exception {


        Demo demo1 = new Demo();

        CamelContext context = new DefaultCamelContext();

        //hello world
//        context.addRoutes(new RouteBuilder() {
//
//            @Override
//            public void configure() throws Exception {
//
//                System.out.println("Hello World");
//
//            }
//        });

        //consumer and producer
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {

                from("direct:start")

                        .process(new Processor() {
                            @Override
                            public void process(Exchange exchange) throws Exception {

                                System.out.println("I am a Processor");

//                                String message = exchange.getIn().getBody(String.class);
//
//                                message+=", I am Processor";
//
//                                exchange.getMessage().setBody(message);

                            }
                        })

//                .to("seda:end");

                //calling class method(class component)
                .to("class:com.example.camel.Demo?method=doSomething");
//                .to("bean:registry");

            }
        });


        context.start();

        ProducerTemplate producerTemplate = context.createProducerTemplate();

        producerTemplate.sendBody("direct:start","Hello Everyone");
//
//        ConsumerTemplate consumerTemplate = context.createConsumerTemplate();
//
//        String body =consumerTemplate.receiveBody("seda:end",String.class);
//
//        System.out.println("body = "+body );
    }
}
