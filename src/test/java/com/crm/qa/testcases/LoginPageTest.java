package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage home;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage=new LoginPage();

    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title=loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"Cogmento CRM");
    }
    @Test(priority = 2)
    public void bellButtonTest(){
        boolean bell=loginPage.validateBellButton();
        Assert.assertTrue(bell);
    }
    @Test(priority = 3)
    public void loginTest(){
        home=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
