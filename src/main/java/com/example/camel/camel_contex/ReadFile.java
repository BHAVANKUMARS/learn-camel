package com.example.camel.camel_contex;

import com.example.camel.request.Student;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.DataFormat;

public class ReadFile {

    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {

                DataFormat dataFormat = new BindyCsvDataFormat(Student.class);

                from("file://C:\\Users\\Appu\\Downloads\\learn-camel (1)\\learn-camel\\src\\main\\resources\\Input")

//                .unmarshal(dataFormat)

                .process(new Processor() {
                            @Override
                            public void process(Exchange exchange) throws Exception {

                                System.out.println("Process Calling .....");

//                        List<Student> studentList = (List<Student>) exchange.getIn().getBody();

//                        studentList.stream().forEach(s-> System.out.println(s));
                            }
                        })

                        .to("direct:data");


                from("direct:data")
                        .to("log:?level=INFO&showBody=true");


                context.start();

                Thread.sleep(5000);

                context.stop();



            }
        });
    }
}
