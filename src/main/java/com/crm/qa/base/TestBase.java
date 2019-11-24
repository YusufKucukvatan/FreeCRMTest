package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebDriverFactory;
import com.crm.qa.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase(){
        try{
            prop=new Properties();
            FileInputStream ip=new FileInputStream("/Users/yusufkucukvatan/IdeaProjects/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName= prop.getProperty("browser");
        driver=WebDriverFactory.getDriver(browserName);

        e_driver=new EventFiringWebDriver(driver);
        //now create object of EventListenerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver=e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);  //We have created TestUtil class in our util package
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAT, TimeUnit.SECONDS); //We have created TestUtil class in our util package
        driver.get(prop.getProperty("url"));
    }

}
