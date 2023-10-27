package com.example.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class LearnTimerRoute extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        //use timer component - to start a process in an interval

        from("timer:startTimer?period=2000")

        .to("log:startTimer");

    }
}
