package com.techproed.tests;

import com.techproed.pages.TestAddressLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class Day12_TestAddressLoginTest {
    @Test
    public void TestAddressLoginTest(){
        //Going to the application page
        Driver.getDriver().get(ConfigReader.getProperty("test_address_url"));
        //Creating the object
        TestAddressLoginPage testAddressLoginPage = new TestAddressLoginPage();
        //Signing in
        testAddressLoginPage.email.sendKeys(ConfigReader.getProperty("test_address_email"));
        testAddressLoginPage.password.sendKeys(ConfigReader.getProperty("test_address_password"));
        testAddressLoginPage.signInButton.click();

        //closing the driver
        Driver.closeDriver();

    }
}
