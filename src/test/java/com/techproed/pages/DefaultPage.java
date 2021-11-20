package com.techproed.pages;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DefaultPage {

    public DefaultPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addUserButton;

    @FindBy(xpath = "//span[.='Hotel Management']")
    public WebElement hotelManagementTab;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsTab;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelListTab;

    @FindBy(xpath = "(//span)[contains(@class,'username')]")
    public WebElement userID;

    @FindBy(className = "page-title")
    public WebElement crntdate;

    @FindBy(xpath = "//tr[]//td[7]")
    public List<WebElement>idDropdownlist;


}