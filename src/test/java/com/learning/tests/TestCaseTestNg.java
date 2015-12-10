package com.learning.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.ProductDisplayPage;


/**
 * Created by Syam on 25-10-2015.
 */
public class TestCaseTestNg {
    public static WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void openBrowser(String browser) {
       //  WebDriver driver;

        try {
            if (browser.equalsIgnoreCase("Firefox")) {
               driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        "C:/chromedriver.exe");
                driver = new ChromeDriver();
            }   /* else if (browser.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver",
                        "D:/Dev/Jars/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }*/

        } catch (WebDriverException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testClickOnSignIn () throws Exception {
        driver.navigate().to("http://jv-dev.dev-tzr.eu/");
       driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       HomePage homePage = PageFactory.initElements(driver, HomePage.class);

     /*   homePage.clickSignIn();
        //Creating New User
        homePage.clickCreateAccount();*/

       homePage.enterSearchText("product");

        homePage.clickSearchButton(driver,"product");

        ProductDisplayPage PDP = PageFactory.initElements(driver,ProductDisplayPage.class);
        PDP.setSize("product");
        PDP.clickOnAddToBasket();
        
        //homePage.hoverOverMiniBasket(driver);
        homePage.clickOnMiniBasketIcon();

    }

}

