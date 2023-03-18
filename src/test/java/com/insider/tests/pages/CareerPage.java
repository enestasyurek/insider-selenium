package com.insider.tests.pages;

import com.google.errorprone.annotations.FormatMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerPage extends BasePage{

    @FindBy(xpath = "//ul[@class='glide__slides']")
    public WebElement locations;

    @FindBy(xpath = "//div[@class='swiper-wrapper']")
    public WebElement lifeAtInsider;

    @FindBy(xpath = "//div[@class='col-12 d-flex flex-wrap p-0 career-load-more']")
    public WebElement teams;

    @FindBy(xpath = "//a[.='See all teams']")
    public WebElement seeAllTeamsBtn;

    @FindBy(xpath = "//a[href='https://useinsider.com/careers/quality-assurance/']")
    public WebElement qaBtn;

}
