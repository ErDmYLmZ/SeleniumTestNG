package com.techproed.javascriptexecutor;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.JSUtils;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_JSUtilTest {
    @Test
    public void scrollIntoView(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement recentBlog=Driver.getDriver().findElement(By.xpath("//*[.='Recent Blog']"));
        JSUtils.scrollIntoViewJS(recentBlog);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(recentBlog.isDisplayed());

    }
    @Test
    public void clickWithJs(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement checkAvailabilityButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.clickElementByJS(checkAvailabilityButton);
        Driver.closeDriver();
    }
    @Test
    public void flashJs(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement checkAvailabilityButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.flash(checkAvailabilityButton);
        Driver.closeDriver();
    }
    @Test
    public void changeColorJs(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement checkAvailabilityButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.changeColor("purple", checkAvailabilityButton);
        Driver.closeDriver();
    }



    }

