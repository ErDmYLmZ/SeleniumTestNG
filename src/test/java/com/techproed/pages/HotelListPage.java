package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
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

        @FindBy(xpath = "(//select[@name='datatable_ajax_length'])[2]")
        public WebElement viewrecords;

        @FindBy(xpath = "(//a[@title='Next'])[2]")
        public WebElement nextButton;

        @FindBy(xpath = "(//input[@class='pagination-panel-input form-control input-mini input-inline input-sm'])[2]")
        public WebElement pageNumber;

        @FindBy(id = "btnPrintTable")
        public WebElement downloadbtn;

        @FindBy(xpath = "(//a[@class='btn btn-xs default'])[1]")
        public WebElement detailLink;

        @FindBy(xpath = "(//div[@class='caption'])[1]")
        public WebElement editHotel;

        @FindBy(xpath = "//button[@class='btn green']")
        public WebElement saveBtn;

        @FindBy(xpath = "(//div[@class='bootbox-body'])[1]")
        public WebElement successMessage;

        @FindBy(id = "Code")
        public WebElement codeArea;

        @FindBy(xpath = "//button[@data-bb-handler='ok']")
        public WebElement okBtn;

        @FindBy(linkText = "Properties")
        public WebElement propertiesRoute;

        @FindBy(id = "product_barcode_84")
        public WebElement barcodeArea;

        @FindBy(xpath = "(//a[@class='btn default btn-sm'])[2]")
        public WebElement updateBtn;

        @FindBy(xpath = "//div[@class='bootbox-body']")
        public WebElement valuedMessage;

        @FindBy(id = "btnDelete")
        public WebElement deletebtn;

        @FindBy(xpath = "//button[@data-bb-handler='confirm']")
        public WebElement confirmMessage;

        @FindBy(xpath = "//div[@class='bootbox-body']")
        public WebElement errorMessage;


























    }

