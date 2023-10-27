package com.example.camel.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class LearnProducerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        //create a servlet using camel-servlet added in pom.xml  & configure a servlet component (default servlet name is camel)
        restConfiguration().component("servlet");

        //base path
        rest("/api")
                .get()
                //destination path
                .to("direct:demo");

        //demo - set the body or content of the demo
        from("direct:demo")
                .transform().constant("Welcome to Learn Camel!!! ");


    }
}
