package com.insider.tests.pages;

import com.insider.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//span[.='More']")
    public WebElement moreButton;

    @FindBy(xpath = "//a[@href='https://useinsider.com/careers/']")
    public WebElement careerButton;
}
