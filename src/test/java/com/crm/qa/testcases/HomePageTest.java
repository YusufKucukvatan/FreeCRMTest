package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    public HomePageTest(){
        super();
    }

    //test cases should be independent from each other
    //before each test case ==>launch the browser+login
    //execute test case and then close the browser
    //We don't use the same browser for all cases, we launch brand new browser for each case.
    //Because of the performance issues (cookies, RAM deficiency, failure, etc.)

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        loginPage=new LoginPage();
        homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void verifyHomePageTitle(){
        String homePageTitle=homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page Title not matched");
    }

    @Test(priority = 2)
    public void verifyUserName(){
        Boolean verifyUser=homePage.verifyUsername();
        Assert.assertTrue(verifyUser,  "Username not matched");
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest(){
        contactsPage=homePage.clickOnContactsLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
