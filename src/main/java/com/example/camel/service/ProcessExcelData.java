package com.example.camel.service;

import com.sun.security.auth.callback.TextCallbackHandler;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ProcessExcelData implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        GenericFile<File> file = (GenericFile<File>) exchange.getIn().getBody();

//        File file = new File("data/input/data.xlsx");

        FileInputStream inputStream = new FileInputStream(file.getFile());

        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        System.out.println("Row Count "+rowCount);

        for(int i=1;i<=rowCount;i++){

            Row row = sheet.getRow(i);

            for(int j=0;j< row.getLastCellNum();j++){

                if(j==0)
                    System.out.println("id = "+row.getCell(j).getNumericCellValue());
                else if(j==1)
                    System.out.println("name = "+row.getCell(j).getStringCellValue());


            }

        }

        exchange.getMessage().setBody("Process Completed");

    }

    public void processExcelInfo() throws IOException {

        File file = new File("data/input/data.xlsx");

        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        System.out.println("Row Count " + rowCount);

        for (int i = 1; i <= rowCount; i++) {

            Row row = sheet.getRow(i);

            for (int j = 0; j < row.getLastCellNum(); j++) {

                if (j == 0)
                    System.out.println("id = " + row.getCell(j).getNumericCellValue());
                else if (j == 1)
                    System.out.println("name = " + row.getCell(j).getStringCellValue());


            }


        }


    }
}
