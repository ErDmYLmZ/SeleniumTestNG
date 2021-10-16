package com.techproed.tests.smoketest;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.pages.MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.dnd.DragGestureEvent;

public class Day12_PositiveLoginTest {
    /*
        Test Case:
        Create a package: smoketest
        Create a class: PositiveTest
        Method: positiveLoginTest
        When user goes to http://www.carettahotel.com/
        And click on Log in
        And send the username and password
        manager
        Manager1!
     */
    @Test
    public void positiveLoginTest(){

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //1.Create page objects-MainPage, Login==> DONE
        //2.Create test class
        //    -Create Page Objects
        //        -Create MainPAge object
        //        -Calling the page elements using that object

        MainPage mainPage = new MainPage();
        mainPage.mainPageLoginLink.click();

        //At this point we are on the LoginPage
        //Create LoginPage object
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();

        //We need to automate the login success
        //We choose a CORE ELEMENT on the page
        //We will use ADD USer button to verify the login loginPage
        //At this point, we are on the Default Page

        DefaultPage defaultPage = new DefaultPage();
        boolean isLoggedIn = defaultPage.addUserButton.isDisplayed();

        Assert.assertTrue(isLoggedIn);

    }

}
