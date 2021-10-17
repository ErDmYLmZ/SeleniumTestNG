package com.techproed.tests.smoketest;
import com.github.javafaker.Faker;
import com.techproed.pages.DefaultPage;
import com.techproed.pages.HotelRoomsPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Day12_HotelRoomCreation {
    LoginPage loginPage;
    DefaultPage defaultPage;
    HotelRoomsPage hotelRoomsPage;
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        loginPage= new LoginPage();
        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();
        //asserting login success
        defaultPage= new DefaultPage();
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());
    }
    @Test
    public void hotelRoomCreate() throws InterruptedException {
//Click on Hotel Management
        defaultPage.hotelManagementTab.click();
//Click on Hotel Rooms
        defaultPage.hotelRoomsTab.click();
//Click on Add Hotel Room
        hotelRoomsPage = new HotelRoomsPage();
        hotelRoomsPage.addHotelRoomLink.click();
//Enter All required fields
        //ID IS DROPDOWN
        Select select = new Select(hotelRoomsPage.idDropdown);
        select.selectByIndex(2);

        //Code
        hotelRoomsPage.code.sendKeys("discount code");

        //Name
        hotelRoomsPage.name.sendKeys(faker.name().fullName());

        //Location
        hotelRoomsPage.location.sendKeys(faker.address().cityName());

        //Description
        hotelRoomsPage.description.sendKeys("TestNG Day13", Keys.ENTER);

        //Price
        WebElement from = hotelRoomsPage.fourhundred;
        WebElement to = hotelRoomsPage.price;
        Thread.sleep(1500);
        actions.dragAndDrop(from, to).build().perform();
        //Thread.sleep(1500);

        //Room select
        Select roomselect = new Select(hotelRoomsPage.roomDropdown);
        roomselect.selectByIndex(9);

        //Adult count
        hotelRoomsPage.adultCount.sendKeys(faker.number().numberBetween(1, 3) + "");

        //Child count
        hotelRoomsPage.childCount.sendKeys(faker.number().numberBetween(1, 3) + "");

        //Approved
        if (!hotelRoomsPage.isApproved.isSelected()) {
            hotelRoomsPage.isApproved.click();
        }

        //Save
        hotelRoomsPage.save.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        WebElement popUpText=wait.until(ExpectedConditions.visibilityOf(hotelRoomsPage.messageAssert));
        //Assert.assertTrue(hotelRoomsPage.messageAssert.getText().contains("HotelRoom was inserted successfully"));
        Assert.assertEquals(popUpText.getText(),"HotelRoom was inserted successfully");
        hotelRoomsPage.okbutton.click();
    }
    @AfterMethod
            public void tearDown(){
        Driver.closeDriver();

    }
}
