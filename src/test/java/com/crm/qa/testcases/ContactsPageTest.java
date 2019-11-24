package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    String sheetName = "contacts";

    public ContactsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        loginPage=new LoginPage();
        testUtil=new TestUtil();
        contactsPage=new ContactsPage();
        homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        homePage.clickOnContactsLink();
    }

    @Test(priority = 1)
    public void verifyContactsPageLabel(){
        Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label not matched");
    }

    @Test(priority = 2)
    public void verifyNameLabel(){
        Assert.assertTrue(contactsPage.verifyNameLabel(), "Name label not matched");
    }

    @Test(priority = 3)
    public void verifyCheckBoxIsSelected(){
        contactsPage.verifyCheckBox();
    }

    @DataProvider
    public Object[][] getCRMTestData() throws IOException {
        Object[][] data = TestUtil.getTestData(sheetName);
        return data;
    }
    @Test(priority = 4, dataProvider = "getCRMTestData")
    public void validateNewContact(String firstname, String lastname, String description, String email) throws InterruptedException {
        contactsPage.createNewContact(firstname, lastname, description, email);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
