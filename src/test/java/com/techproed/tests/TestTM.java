package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTM {
    /*
    /Get url from config.properties file Get the title from config.properties file
     */
@Test
    public void confTest(){
    Driver.getDriver().get(ConfigReader.getProperty("app_url"));
    Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));

}


}
