package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Day11_CarettaHotelLoginConfigTest {

    @Test
    public void logIn(){

        Driver.getDriver().get(ConfigReader.getProperty("login_url"));

        WebElement userName = Driver.getDriver().findElement(By.id("UserName"));
        userName.sendKeys(ConfigReader.getProperty("admin_username"));

        WebElement password = Driver.getDriver().findElement(By.id("Password"));
        password.sendKeys(ConfigReader.getProperty("admin_password")+ Keys.ENTER);
    }
}
