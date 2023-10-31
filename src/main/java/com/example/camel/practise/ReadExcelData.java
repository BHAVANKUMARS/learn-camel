package com.example.camel.practise;

import com.example.camel.service.ProcessExcelData;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ReadExcelData extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("file:data/input?noop=true")

        .choice()

        .when(header("CamelFileName").contains(".xlsx")).to("direct:processExcelData")

        .otherwise().to("direct:doNotProcess")

        .end();

        //process excel data
        from("direct:processExcelData")

        .process(new ProcessExcelData())

        .to("log:?level=INFO&showBody=true");


        //do Not Process
        from("direct:doNotProcess")

        .process(ex->ex.getMessage().setBody("Do not Process because it is not a excel file"))

        .to("log:?level=INFO&showBody=true");

    }
}
