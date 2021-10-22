package com.techproed.excelautomation;

import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Day15_Review_LoginSmokeTest {
    /*
  Java class : LoginSmokeTest
  Methods :adminLoginTest
  Methods :managerLoginTest
   */
    /*
          loginPage.username.sendKeys("manager");
        loginPage.password.sendKeys("Manager1!");
        loginPage.loginButton.click();
     */
    LoginPage loginPage;
    ExcelUtil excelUtil;
    List<Map<String,String>> testData;
    /*
      getDataList List<Map<String,String>
     */
    @Test
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_qa_environment"));
        loginPage = new LoginPage();
        try {
            loginPage.advancedLink.click();
            TimeUnit.SECONDS.sleep(3);
            loginPage.proceedLink.click();
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            System.out.println("There is not such an element!");
        }
    }
    @Ignore
    @Test
    public void adminLoginTest() throws InterruptedException {
        String path = "src/test/java/resources/smoketestdata.xlsx";
        String sheetName = "admin_login_info";
        excelUtil = new ExcelUtil(path,sheetName);
        System.out.println("excelUtil.getDataList() = " + excelUtil.getDataList());
        List<Map<String,String>> testData = excelUtil.getDataList();
        for (Map<String,String> eachData:testData){
               setUp();
            loginPage.username.sendKeys(eachData.get("username")); // admin
            loginPage.password.sendKeys(eachData.get("password")); // password Techproed123!
            loginPage.loginButton.click();
        }
    }
    @Ignore
    @Test
    public void managerLogin() throws InterruptedException {
        String path = "src/test/java/resources/smoketestdata.xlsx";
        String sheetName = "manager_login_info";
        excelUtil = new ExcelUtil(path,sheetName);
        System.out.println("excelUtil.getDataList() = " + excelUtil.getDataList());
        List<Map<String,String>> testData = excelUtil.getDataList();
        for (Map<String,String> eachData:testData){
            setUp();
            loginPage.username.sendKeys(eachData.get("username")); // admin
            loginPage.password.sendKeys(eachData.get("password")); // password Techproed123!
            loginPage.loginButton.click();
        }
    }

    @Test
    public void negativeLogin() throws InterruptedException {
        String path = "src/test/java/resources/smoketestdata.xlsx";
        String sheetName = "negative_login_info";
        excelUtil=new ExcelUtil(path, sheetName);
        testData=excelUtil.getDataList();
        for (Map<String,String> eachData:testData) {
            setUp();
            loginPage.username.sendKeys(eachData.get("username"));
            loginPage.password.sendKeys(eachData.get("password"));
            loginPage.loginButton.click();

        }

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}