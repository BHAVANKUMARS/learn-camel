package com.example.camel.camel_contex;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFiles {

    public static void main(String[] args) {

        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {

                    from("file:data/source?noop=true")

//                    .log("Received Message "+"${body}"+"${headers}")
                    .to("log:?level=INFO&showBody=true&showHeaders=true")

                    //In mentioned path destination folder is not created, camel will create the folder and copy the file to destination folder.If present, it copy the file to destination folder
                    .to("file:data/destination");

                    /*  uri have 3 parts

                            component(file),context path(data/source),additional option()

                     */

                }
            });

            //need to the start context path, it internally start the routesBuilder
            context.start();

            Thread.sleep(5000);

            context.stop();


        } catch (Exception e) {

            System.out.println("Exception "+e);

            e.printStackTrace();
        }

    }


}
