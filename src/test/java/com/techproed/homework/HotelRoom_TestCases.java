package com.techproed.homework;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import com.techproed.pages.DefaultPage;
import com.techproed.pages.HotelListPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;



public class HotelRoom_TestCases {
    LoginPage loginPage;
    DefaultPage defaultPage;
    HotelListPage hotelListPage;
    Faker faker = new Faker();

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
        defaultPage = new DefaultPage();
        defaultPage.hotelManagementTab.click();
        defaultPage.hotelListTab.click();
        ReusableMethods.waitFor(5);

    }
    @Test
    public void hotelRoomIdType1() throws InterruptedException {
        hotelListPage = new HotelListPage();
        Select select = new Select(hotelListPage.IDGroupSelect);
        select.selectByIndex(2);
        TimeUnit.SECONDS.sleep(2);

        hotelListPage.SearchButton.click();
        TimeUnit.SECONDS.sleep(1);
        List<WebElement> hotelIdColumn = Driver.getDriver().findElements(By.xpath("//tbody//tr//td[7]"));
        List<String> listOfIds = new ArrayList<>();
        for (WebElement eachId : hotelIdColumn) {
            listOfIds.add(eachId.getText());
        }
        Assert.assertFalse(listOfIds.contains("Hotel Type2"));

        select.selectByIndex(1);
        hotelListPage.SearchButton.click();
        TimeUnit.SECONDS.sleep(1);
        List<WebElement> hotelIdColumn2 = Driver.getDriver().findElements(By.xpath("//tbody//tr//td[7]"));
        List<String> listOfIds2 = new ArrayList<>();
        for (WebElement eachId : hotelIdColumn2) {
            listOfIds2.add(eachId.getText());
        }
        Assert.assertFalse(listOfIds2.contains("Hotel Type1"));

        hotelListPage.ClearButton.click();
        TimeUnit.SECONDS.sleep(1);
        List<WebElement>allHotelIds = Driver.getDriver().findElements(By.xpath("//tbody//tr//td[7]"));
        List<String>allHotelIdsString = new ArrayList<>();
        for (WebElement eachAllId:allHotelIds){
            allHotelIdsString.add(eachAllId.getText());
            //System.out.println(allHotelIdsString);
        }

        Assert.assertTrue(allHotelIdsString.contains("Hotel Type1") && allHotelIdsString.contains("Hotel Type2"));
        Thread.sleep(5000);
        Driver.closeDriver();
    }
    @Test
    public void dateFormatTest(){

        String  websiteDate = defaultPage.crntdate.getText();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        LocalDate now =LocalDate.now();

        Assert.assertEquals(websiteDate,dateTimeFormatter.format(now));

    }
    @Test
    public void viewRecordTest() throws InterruptedException {

            Select viewrecords = new Select(hotelListPage.viewrecords);
            Assert.assertEquals("viewrecords.getFirstSelectedOption().getText()","10");
            TimeUnit.SECONDS.sleep(3);

            viewrecords.selectByValue("20");
            Thread.sleep(3000);
            Assert.assertEquals(ReusableMethods.getElementsText(By.xpath("//tbody//td[7]")).size(),20);

    }
    @Test
    public void nextBtnTest() throws InterruptedException {
        WebElement next = hotelListPage.nextButton;
        JSUtils.scrollIntoViewJS(next);
        ReusableMethods.waitFor(2);
        hotelListPage.nextButton.click();
        TimeUnit.SECONDS.sleep(2);
        Assert.assertEquals(hotelListPage.pageNumber.getAttribute("value"), "2");

    }
    @Test
    public void download(){
        hotelListPage.downloadbtn.click();
        ReusableMethods.waitFor(1);
        String homePath = System.getProperty("user.home");
        String pathOflist = homePath+"/Desktop/Admin - List Of Hotels.xlsx";
        Assert.assertTrue(Files.exists(Paths.get(pathOflist)));
    }
    @Test
    public void editHotel() throws InterruptedException {
        hotelListPage.detailLink.click();
        String window1Handle =Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().window(window1Handle);
        TimeUnit.SECONDS.sleep(2);

        Assert.assertTrue(hotelListPage.editHotel.isDisplayed());

        hotelListPage.codeArea.clear();
        hotelListPage.codeArea.sendKeys(faker.number().digits(5));
        ReusableMethods.waitFor(2);
        hotelListPage.saveBtn.click();
        ReusableMethods.waitFor(2);
        Assert.assertEquals(hotelListPage.successMessage.getText(), "Hotel was updated successfully");

        hotelListPage.okBtn.click();

        hotelListPage.propertiesRoute.click();
        ReusableMethods.waitFor(2);
        hotelListPage.barcodeArea.clear();
        hotelListPage.barcodeArea.sendKeys(faker.number().digits(4));
        hotelListPage.updateBtn.click();
        ReusableMethods.waitFor(1);

        Assert.assertEquals(hotelListPage.valuedMessage.getText(), "Value was updated Succesfully");
        hotelListPage.okBtn.click();

        hotelListPage.deletebtn.click();
        ReusableMethods.waitFor(1);
        Assert.assertEquals(hotelListPage.confirmMessage.getText(), "Would you like to continue?");

        hotelListPage.okBtn.click();
        ReusableMethods.waitFor(2);
        Assert.assertEquals(hotelListPage.errorMessage.getText(), "Error: Couldn't delete hotel : please delete rooms for this hotel first");

    }

        @Ignore
        @AfterMethod
        public void tearDown(){
            Driver.closeDriver();

        }

    }







