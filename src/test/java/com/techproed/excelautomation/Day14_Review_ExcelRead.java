package com.techproed.excellautomation;

import com.techproed.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day14_Review_ExcelRead {
    /*
    Create a new test method : readExcel()
Store the path of the file in a string
Open the file
Open the workbook using fileinputstream
Open the first worksheet
Go to first row
Go to first cell on that first row and print
Go to second cell on that first row and print
Go to 2nd row first cell and assert if the data equal to USA
Go to 3rd row 2nd cell-chain the row and cell
Find the number of row
Find the number of used row
Print country, capitol key value pairs as map object
     */

    @Test
    public void readExcel() throws IOException {
        String path = "./src/test/java/resources/Capitols.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell firstCell = row.getCell(0);
        System.out.println(firstCell);

        Row secondRow = sheet.getRow(1);
        //Cell secondCell = secondRow.getCell(0);
        Cell secondCell = sheet.getRow(1).getCell(0);
        System.out.println(secondCell);

        Cell thirdCell = sheet.getRow(2).getCell(1);
        System.out.println(thirdCell);

        String SThirdCell = sheet.getRow(2).getCell(1).toString();
        System.out.println(SThirdCell);

        int numOfRow = sheet.getLastRowNum() + 1;
        System.out.println(numOfRow);

        int pysNumOfRows = sheet.getPhysicalNumberOfRows();
        System.out.println(pysNumOfRows);

        Map<String, String> CapitolsMap = new HashMap<>();
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            String countries = sheet.getRow(i).getCell(0).toString();
            //System.out.println(countries);
            String capito = sheet.getRow(i).getCell(1).toString();
            //System.out.println(capito);


            CapitolsMap.put(countries, capito);
            System.out.println(CapitolsMap.toString());


        }
    }
        @Test
        public void demo () {
            String path = "src/test/java/resources/Capitols.xlsx";
            String sheetName ="Sayfa1";
                    ExcelUtil excelUtil = new ExcelUtil(path, sheetName);
            System.out.println(excelUtil.getDataList());
        }
    }



