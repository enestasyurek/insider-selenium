package com.insider.tests.tests;

import com.insider.tests.pages.BasePage;
import com.insider.tests.pages.CareerPage;
import com.insider.tests.pages.JobApplyFormPage;
import com.insider.tests.pages.QualityAssurancePage;
import com.insider.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.insider.tests.utilities.BrowserUtils.*;


public class insiderTest {

    BasePage basePage = new BasePage();
    CareerPage careerPage = new CareerPage();
    QualityAssurancePage qualityAssurancePage = new QualityAssurancePage();
    JobApplyFormPage jobApplyFormPage = new JobApplyFormPage();
    @Test(priority = 1)
    public void checkHomePage(){
        Driver.getDriver().get("https://useinsider.com/");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://useinsider.com/","Failed to open Insider home page");


    }
    @Test(priority = 2)
    public void checkCareerPage(){
        clickWithTryCatch(basePage.moreButton);
        clickWithTryCatch(basePage.careerButton);
        Assert.assertTrue(careerPage.locations.isDisplayed());
        Assert.assertTrue(careerPage.lifeAtInsider.isDisplayed());
        Assert.assertTrue(careerPage.teams.isDisplayed());
    }

    @Test(priority = 3)
    public void filterJob(){
        clickWithJSExe(careerPage.seeAllTeamsBtn);
        clickWithJSExe(careerPage.qaBtn);

        clickWithJSExe(qualityAssurancePage.seeAllQAJobsBtn);

        Select select = new Select(qualityAssurancePage.locationFilter);
        select.selectByVisibleText("Istanbul, Turkey");

        sleep(1);
        try {
            // Check if job listings are present
            Assert.assertFalse(qualityAssurancePage.noPositionAvailableTest.isDisplayed());
        } catch (NoSuchElementException e) {

            System.out.println("Job list is present");
            for (WebElement job : qualityAssurancePage.jobList){
                ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", job);
                sleep(1);

                WebElement departmentElement = job.findElement(By.xpath(".//span[contains(@class,'position-department')]"));
                WebElement locationElement = job.findElement(By.xpath(".//div[contains(@class,'position-location')]"));
                WebElement applyNowButton = job.findElement(By.xpath(".//a[contains(text(),'Apply Now')]"));

                String departmentText = departmentElement.getText();
                String locationText = locationElement.getText();

                Assert.assertTrue(departmentText.contains("Quality Assurance"));
                Assert.assertTrue(locationText.contains("Istanbul, Turkey"));
                Assert.assertTrue(applyNowButton.isEnabled());

            }
            }

        qualityAssurancePage.applyBtn.click();
        sleep(2);

        try {
            Assert.assertTrue(jobApplyFormPage.attachResumeBtn.isDisplayed());
        }catch (NoSuchElementException e){
            System.out.println("Couldn't redirect to form page");
            Assert.fail();
        }

        Driver.closeDriver();
    }


}
