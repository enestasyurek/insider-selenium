package com.insider.tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.WeakHashMap;

public class QualityAssurancePage extends BasePage{
    @FindBy(xpath = "//a[.='See all QA jobs']")
    public WebElement seeAllQAJobsBtn;

    @FindBy(xpath = "//select[@id='filter-by-location']")
    public WebElement locationFilter;

    @FindBy(xpath = "//a[.='No positions available.']")
    public WebElement noPositionAvailableTest;

    @FindBy(xpath = "//div[@data-team='qualityassurance']")
    public List<WebElement> jobList;

    @FindBy(xpath = "//a[contains(text(),'Apply Now')]")
    public WebElement applyBtn;
}
