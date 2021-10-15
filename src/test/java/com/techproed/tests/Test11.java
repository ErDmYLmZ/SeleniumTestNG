package com.techproed.tests;


import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test11 {

    @Test
    public void amazonTest(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));

        Assert.assertTrue(Driver.getDriver().getTitle().contains("amazon"));

        WebElement SB = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        SB.sendKeys("book", Keys.ENTER);


        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Best seller"));
    }
}