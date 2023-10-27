package com.example.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.StringTokenizer;

@Component
public class LearnFileRoute extends RouteBuilder {

    //using file component(mention the source and destination path in file Component ) transfer/copy the file from source to destination
    //source file are once sent to destination
    //In source folder files are exit as backup in camel
    //source is in listening mode
    //if send same file from source, it override the same file in destination

    @Override
    public void configure(){

        //mention the file path source path
        from("file://C:\\Users\\Appu\\Downloads\\learn-camel (1)\\learn-camel\\src\\main\\resources\\Input")

        //from("file:C:\\Downloads?noop=true")  - avoiding sending duplicate File(if noop=true)
        // NOOP - No Operation To Override a Program

         //from({"my.app.source"}) - here {my.app.source} ==> configured/assigned value in application.properties(get value from properties file)
         //.to({"my.app.destination"}) - here {my.app.destination} ==>configured/assigned value in application.properties(get value from properties file)

        //log the file content
        .log("${body}")


        .process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {

                System.out.println("source "+exchange);

                //Get Source Data
                Message message = exchange.getIn();

                String body = message.getBody(String.class);

                //Modify/set the output
                StringTokenizer data = new StringTokenizer(body,",");

                String eId = data.nextToken();
                String eName = data.nextToken();
                String eSalary =data.nextToken();

                String output= "{eId:"+eId+",eName:"+eName+",eSalary:"+eSalary+"}";

                Message out = exchange.getMessage();

                out.setBody(output);

                System.out.println(exchange.getMessage().getBody());


            }
        })

//        .to("file://C:\\Users\\Appu\\Downloads\\learn-camel (1)\\learn-camel\\src\\main\\resources\\Output");
                //need to modify the fileName or extension
        .to("file://C:\\Users\\Appu\\Downloads\\learn-camel (1)\\learn-camel\\src\\main\\resources\\Output?");

    }
}
