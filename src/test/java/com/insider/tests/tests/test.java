package com.insider.tests.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.insider.tests.pages.BasePage;
import com.insider.tests.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test {

    BasePage basePage = new BasePage();
    @Test(priority = 1)
    public void checkHomePage(){
        Driver.getDriver().get("https://useinsider.com/");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://useinsider.com/","Failed to open Insider home page");


    }
    @Test
    public void checkCareerPage(){
        basePage.moreButton.click();
        basePage.careerButton.click();
        Driver.closeDriver();
    }
}
