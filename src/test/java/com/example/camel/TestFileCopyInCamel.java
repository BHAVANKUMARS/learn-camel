//package com.example.camel;
//
//import com.example.camel.routes.LearnFileCopyRoute;
//import org.apache.camel.RoutesBuilder;
//import org.apache.camel.test.junit4.CamelTestSupport;
//import org.junit.jupiter.api.Test;
//
//import java.io.File;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class TestFileCopyInCamel extends CamelTestSupport {
//
//
//    @Override
//    protected RoutesBuilder createRouteBuilder() throws Exception {
//
//        //it will execute configure method
//        return new LearnFileCopyRoute();
//    }
//
//    @Test
//    public void checkFileIsTransferredIntoDesFolder() throws Exception {
//
//
//
//        Thread.sleep(5000);
//
//        File file = new File("C:\\Users\\Appu\\Downloads\\learn-camel (1)\\learn-camel\\src\\main\\resources\\Output");
//
//        assertTrue(file.isDirectory());
//
////        assertEquals(1,file.listFiles().length);
//
//    }
//
//}
