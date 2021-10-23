package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelListPage {
    public HotelListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
        @FindBy(id = "lkpGroups")
        public WebElement IDGroupSelect;

        @FindBy(xpath = "//button[@class ='btn btn-sm yellow filter-submit margin-bottom']")
        public WebElement SearchButton;

        @FindBy(xpath = "//button[@class ='btn btn-sm red filter-cancel']")
        public WebElement ClearButton;





















    }

