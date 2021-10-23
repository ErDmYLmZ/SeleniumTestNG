package com.techproed.homework;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.HotelListPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HotelRoom_TestCases {
    LoginPage loginPage;
    DefaultPage defaultPage;
    HotelListPage hotelListPage;
    ExcelUtil excelUtil;


    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_qa_environment"));
        loginPage = new LoginPage();
        try {
            TimeUnit.SECONDS.sleep(1);
            loginPage.advancedLink.click();
            TimeUnit.SECONDS.sleep(1);
            loginPage.proceedLink.click();
        } catch (Exception e) {
            System.out.println("Unable to find the link");
        }
        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();
    }
    @Test
    public void hotelRoomCreate() throws InterruptedException {
        defaultPage = new DefaultPage();
        defaultPage.hotelManagementTab.click();
        defaultPage.hotelListTab.click();

        hotelListPage = new HotelListPage();
        Select select = new Select(hotelListPage.IDGroupSelect);
        select.selectByIndex(2);

        hotelListPage.SearchButton.click();
        TimeUnit.SECONDS.sleep(1);
        List<WebElement> hotelIdColumn = Driver.getDriver().findElements(By.xpath("//tbody//tr//td[7]"));
        List<String>listOfIds=new ArrayList<>();
        for (WebElement eachId:hotelIdColumn) {
            listOfIds.add(eachId.getText());
        }

        Assert.assertFalse(listOfIds.contains("Hotel Type2"));
//        System.out.println("Hotel ID Number ==> " + hotelId.size());
//        int cellNum = 1;
//        for (WebElement eachCell : hotelId) {
//            System.out.println(cellNum + " : " + eachCell.getText());
//            cellNum++;

       // }

//@Ignore
//@AfterMethod
//    public void tearDown(){
//        Driver.closeDriver();
//    }
    }

}
