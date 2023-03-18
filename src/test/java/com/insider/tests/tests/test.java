package com.insider.tests.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.insider.tests.pages.BasePage;
import com.insider.tests.pages.CareerPage;
import com.insider.tests.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test {

    BasePage basePage = new BasePage();
    CareerPage careerPage = new CareerPage();
    @Test(priority = 1)
    public void checkHomePage(){
        Driver.getDriver().get("https://useinsider.com/");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://useinsider.com/","Failed to open Insider home page");


    }
    @Test(priority = 2)
    public void checkCareerPage(){
        basePage.moreButton.click();
        basePage.careerButton.click();

        Assert.assertTrue(careerPage.locations.isDisplayed());
        Assert.assertTrue(careerPage.lifeAtInsider.isDisplayed());
        Assert.assertTrue(careerPage.teams.isDisplayed());
    }

    @Test(priority = 3)
    public void filterJob(){
        careerPage.seeAllTeamsBtn.click();
        careerPage.qaBtn.click();
        Driver.closeDriver();
    }
}
