package com.example.camel.definition;

public class LearnRouteBuilder {

    /*

    //automatically executed by thread in spring-boot(individual thread/background thread)

    when run the main thread route builder also run


    get the data from consumer to send to producer using RouteBuilder Class

    from - specify the route (consume the data ... file path,end point,timer)

    three part
    EndPoint from("file:F://data?noop=true")

    file - component

    F://data - context path

    noop=true - additional option

    to   - specify the route(send the data.....file path,end point,timer)

    log  - log the data

    process - business process(log the source using Exchange)

    Have abstract method in RouteBuilder - must override the method (method name - configure())

    Using this method implement the route codes in RouteBuilder (AbstractClass)



    */
}


