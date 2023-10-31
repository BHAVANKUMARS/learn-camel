package com.example.camel.practise;

import com.example.camel.request.Employee;
import com.example.camel.request.Student;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class ReadCsvFile extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        DataFormat dataFormat = new BindyCsvDataFormat(Student.class);

        from("file://C:\\Users\\Appu\\Downloads\\learn-camel (1)\\learn-camel\\src\\main\\resources\\Input")


                .unmarshal(dataFormat)

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


    }
}
