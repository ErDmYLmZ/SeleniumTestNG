package com.techproed.excelautomation;
import com.techproed.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class Day15_Review_WriteExcel {
    /*
     WRITE EXCEL
    Create a new class: WriteExcel
    Create a new method: writeExcel()
    Store the path of the file as string and open the file
Open the workbook
Open the first worksheet
Create a cell on the 3rd column (2nd index) on the first row Write “POPULATION” on that cell
Create a cell on the 2nd row 3rd cell(index2), and write 150000 Create a cell on the 3rd row 3rd cell(index2), and write 250000 Create a cell on the 4th row 3rd cell(index2), and write 54000 Write and save the workbook
Close the file
Close the workbook
     */
    @Test
    public void writeExcel() throws Exception {
        //Store the path of the file as string and open the file
        String path = "src/test/java/resources/Capitols.xlsx";
        // Open the workbook
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        // Open the first sheet
        Sheet sheet = workbook.getSheetAt(0);
        // Go to the first row
        Row firstRow = sheet.getRow(0);  // index of rows start from 0
        //Create a cell on the 3rd column (2nd index) on the first row Write “POPULATION” on that cell
        // to create cell we have to use create cell method
        Cell row1cell3 = firstRow.createCell(2);
        // Write sth -- setCellValue
        //  sheet.getRow(0).createCell(2).setCellValue("POPULATION");
        row1cell3.setCellValue("POPULATION");
        // Create a cell on the 2nd row 3rd cell(index2), and write 150000
        // row index first index
        // column index 2 nd
        Cell row2cell3 = sheet.getRow(1).createCell(2);
        row2cell3.setCellValue("150000");
        //Create a cell on the 3rd row 3rd cell(index2), and write 250000
        Cell row3cell3 = sheet.getRow(2).createCell(2);
        row3cell3.setCellValue("250000");
        //Create a cell on the 4th row 3rd cell(index2), and write 5400
        Cell row4cell3 = sheet.getRow(3).createCell(2);
        row4cell3.setCellValue("54000");
        //Close the file
        // Write and Save the file
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        // Saving file
        workbook.write(fileOutputStream);
        //Close the workbook
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }
    @Test
    public void excelUtilDemo(){
        //String path, String sheetName
        String path = "./src/test/java/resources/Capitols.xlsx";
        String sheetName = "Sayfa1";
        ExcelUtil excelUtil = new ExcelUtil(path,sheetName);
        //Create a cell on the 5rd row 3rd cell(index2), and write 110000
        excelUtil.setCellData("110000",4,2);
        // Create a cell on the 6rd row cell named "POPULATION", and write 5670000
        excelUtil.setCellData("5670000","POPULATION",5);
        System.out.println("excelUtil.getDataList() = " + excelUtil.getDataList());
    }
}
