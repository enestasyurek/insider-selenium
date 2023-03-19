package com.insider.tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobApplyFormPage extends BasePage{
    @FindBy(xpath = "//input[@name='resume']")
    public WebElement attachResumeBtn;
}
