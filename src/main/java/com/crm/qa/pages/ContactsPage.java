package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.osgl.util.Str;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
    WebElement contactsLabel;

    @FindBy(xpath = "//table[@class=\"ui celled sortable striped table custom-grid table-scroll\"]/thead/tr/th[2]")
    WebElement name;

    @FindBy(xpath = "//input[@type=\"checkbox\"]")
    WebElement chechBox;

    @FindBy(xpath = "//a[@href=\"/contacts/new\"]")
    WebElement newContact;

    @FindBy(xpath = "//input[@name=\"first_name\"]")
    WebElement firstName;

    @FindBy(xpath = "//input[@name=\"last_name\"]")
    WebElement lastName;

    @FindBy(xpath = "//div[@class=\"four wide field\"]/button")
    WebElement publicButton;

    @FindBy(xpath = "//div[@class=\"twelve wide field\"]")
    WebElement dropdown;

    @FindBy(xpath = "//button[@class=\"ui linkedin button\"]")
    WebElement saveButton;

    @FindBy(xpath = "//input[@placeholder=\"Email address\"]")
    WebElement email;

    @FindBy(xpath = "//textarea[@name=\"description\"]")
    WebElement description;

    //Here we are initializing HomePage objects
    public ContactsPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyContactsLabel(){
        return contactsLabel.isDisplayed();
    }

    public boolean verifyNameLabel(){
        return name.isDisplayed();
    }

    public boolean verifyCheckBox(){
        chechBox.click();
        return chechBox.isSelected();
    }

    public void createNewContact(String firstName, String lastName,  String description, String email) throws InterruptedException {
        newContact.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.description.sendKeys(description);
        this.email.sendKeys(email);
//        publicButton.click();
//        dropdown.click();
//        Actions action=new Actions(driver);
//        action.moveToElement(driver.findElement(By.xpath("//div[@class=\"visible menu transition\"]"))).click().build().perform();
        saveButton.click();
    }
}
