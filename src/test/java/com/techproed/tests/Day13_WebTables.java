package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.pages.DefaultPage;
import com.techproed.pages.HotelRoomsPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Day13_WebTables {
    /*
        Create a class: WebTables
        Create a method: login()
        Log in https://www.carettahotel.com/
        //Click on Hotel Management
        //Click on Hotel Rooms

     */

        LoginPage loginPage;
        DefaultPage defaultPage;
        HotelRoomsPage hotelRoomsPage;
        //    When user goes to HotelRoom page on the application
        @BeforeMethod
        public void setUp() {

            Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
            loginPage = new LoginPage();
            loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
            loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
            loginPage.loginButton.click();
            //asserting login success
            defaultPage = new DefaultPage();
            Assert.assertTrue(defaultPage.addUserButton.isDisplayed());
            //Click on Hotel Management
            defaultPage.hotelManagementTab.click();
            //Click on Hotel Rooms
            defaultPage.hotelRoomsTab.click();
            //Click on Add Hotel Room
            hotelRoomsPage = new HotelRoomsPage();
        }
            @Test
            public void entireTables(){
//                Create a test method: entireTable() and print all of headers
                System.out.println("*Entire Table*");
                System.out.println("*Table Body*");
                WebElement tableBody = Driver.getDriver().findElement(By.xpath("//table//tbody"));
                System.out.println(tableBody.getText());

                List<WebElement>allHeaders = Driver.getDriver().findElements(By.xpath("//th"));
                for (WebElement eachHeader : allHeaders){
                    System.out.println(eachHeader.getText());
                }




//                Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column
            }


            @Test  //  Create a test method: printRows() and Print all of the rows and print the element s on the 4th row
            public void printRows(){
                System.out.println("*Print all of the rows*");
                List<WebElement> allRows = Driver.getDriver().findElements(By.xpath("//tbody//tr"));
                int rowNum=1;
                for (WebElement eachRow:allRows){
                    System.out.println("Row Number "+rowNum + " => "+eachRow.getText());
                    rowNum++;
                }
                //Print row4 only
                WebElement row4 = Driver.getDriver().findElement(By.xpath("//tbody//tr[4]"));
                System.out.println("ROW 4 => "+row4.getText());
            }
             @Test      //Create a test method: printCells() and a the total number of cells in the table body and print all of the cells
            public void printCells() {
                 System.out.println("*Print all of the cells*");
                 List<WebElement> allCells = Driver.getDriver().findElements(By.xpath("//td"));
                 System.out.println("Total Cell Number ==> " + allCells.size());
                 int cellNum = 1;
                 for (WebElement eachCell : allCells) {
                     System.out.println(cellNum + " : " + eachCell.getText());
                     cellNum++;
                 }
             }
            @Test  //Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 5th column
            public void printColumns(){
                     List<WebElement>allHeaders=Driver.getDriver().findElements(By.xpath("//th"));
                     int numberOfColumns=allHeaders.size();
                System.out.println("There are "+numberOfColumns+" columns.");

                //       Print the elements of the 5th column
                List<WebElement> column5Data = Driver.getDriver().findElements(By.xpath("//table//tbody//tr//td[5]"));
                int columnNum=1;
                for (WebElement eachColumn : column5Data){
                    System.out.println("Data "+columnNum+" : "+eachColumn.getText());
                    columnNum++;
                }

                 }



           @Test
           public void printRow_Col(){
            //    This method should print the given cell.
                printData(2,3);//==>2.row and 3.column refers to :111
                printData(4,4);//==>4.row and 4.column refers to :asdf
                printData(6,1);//==>6.row and 1.column refers to :21
            }

            public void printData(int row,int column) {
            //    Create a test method: printData(int row, int column);

                WebElement printData = Driver.getDriver().findElement(By.xpath("//table//tbody//tr["+row+"]//td["+column+"]"));
                System.out.println(row + ".row and " + column + ".column refers to :" + printData.getText());
            }
            //    Example: printData(2,3); should print 2nd row,3rd column

            @AfterMethod
            public void tearDown(){
            Driver.closeDriver();
            }
        }

