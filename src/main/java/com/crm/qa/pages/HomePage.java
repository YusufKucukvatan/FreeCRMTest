package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class HomePage extends TestBase {

    // All those stuff is page library for HomePage. It should contain all details of this page.
    // But we are not gonna test in this page. We will only use this class as a library in HomePageTest class.

    @FindBy(xpath = "//div[@id='top-header-menu']/div[3]/span[1]")
    @CacheLookup // ==> Instead of searching element's xpath, the element is stored in cache memory and it can be called faster than using xpath.
                 // ==> If we are using the same WebElement in our codes, We should use this @CacheLookup annotation.
                 // ==> But; if the web page is refreshed or something happened in web page, out Cache Memory will be spoiled.
    WebElement usernameLabel;

    @FindBy(xpath="//div[@id='main-nav']/a[2]")
    WebElement calenderLink;

    @FindBy(xpath="//div[@id='main-nav']/a[3]")
    WebElement contactsLink;

    @FindBy(xpath="//div[@id='main-nav']/a[5]")
    WebElement dealsLink;

    @FindBy(xpath="//div[@id='main-nav']/a[6]")
    WebElement tasksLink;

    //Here we are initializing HomePage objects
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink(){
        tasksLink.click();
        return new TasksPage();
    }
    public boolean verifyUsername(){
        return usernameLabel.isDisplayed();
    }



}
