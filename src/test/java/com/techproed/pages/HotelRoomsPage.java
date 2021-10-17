package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelRoomsPage {

    public HotelRoomsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "ADD HOTELROOM")
    public WebElement addHotelRoomLink;

    @FindBy(id = "IDHotel")
    public WebElement idDropdown;

    @FindBy(id = "Code")
    public WebElement code;

    @FindBy(id = "Name")
    public WebElement name;

    @FindBy(id = "Location")
    public WebElement location;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement description;

    @FindBy(id = "Price")
    public WebElement price;

    @FindBy(xpath = "//li[@data-id='400']")
    public WebElement fourhundred;

    @FindBy(id = "IDGroupRoomType")
    public WebElement roomDropdown;

    @FindBy(id = "MaxAdultCount")
    public WebElement adultCount;

    @FindBy(id = "MaxChildCount")
    public WebElement childCount;

    @FindBy(id = "IsAvailable")
    public WebElement isApproved;

    @FindBy(id = "btnSubmit")
    public WebElement save;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement messageAssert;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement okbutton;

}

//Locate all objects in this class


//}
