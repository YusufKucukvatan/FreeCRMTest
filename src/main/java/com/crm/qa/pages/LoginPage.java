package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class LoginPage extends TestBase {

    //Page Factory (OR-Object Repository):
    @FindBy(name="email")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//div[@class='ui fluid large blue submit button']")
    WebElement loginButton;

    @FindBy(id="onesignal-bell-launcher")
    WebElement bellButton;

    //Initializing Page Objects:
    public LoginPage(){   // ==> We created constructor here to initialize all those web elements above.
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateBellButton(){
        return bellButton.isDisplayed();
    }

    public HomePage login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        return new HomePage();
    }
}
