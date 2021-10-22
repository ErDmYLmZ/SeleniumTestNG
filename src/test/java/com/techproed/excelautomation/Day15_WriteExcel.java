package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day15_WriteExcel {
    /*
    Create a new class: WriteExcel
    Create a new method: writeExcel()
    Store the path of the file as string and open the file
    Open the workbook
    Open the first worksheet
    Go to the first row
    Create a cell on the 2rd index(3rd Column) on the first row
    Write “POPULATION” on that cell
    //        Create a cell on the 2nd row 3rd cell(index2), and write 150000
//        Create a cell on the 3rd row 3rd cell(index2), and write 250000
//        Create a cell on the 4th row 3rd cell(index2), and write 54000
    Write and save the workbook
    Close the file
    Close the workbook
     */
    @Test
    public void writeExcel() throws IOException {
        String path = "./src/test/java/resources/Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
//        Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row firstRow = sheet.getRow(0);
        Cell row1Cell3 = firstRow.createCell(2);
        row1Cell3.setCellValue("POPULATION");

        //        Create a cell on the 2nd row 3rd cell(index2), and write 150000
        sheet.getRow(1).createCell(2).setCellValue("150000");

//        Create a cell on the 3rd row 3rd cell(index2), and write 250000
        sheet.getRow(2).createCell(2).setCellValue("250000");

//        Create a cell on the 4th row 3rd cell(index2), and write 54000
        sheet.getRow(3).createCell(2).setCellValue("54000");

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();

        workbook.close();

    }
}
