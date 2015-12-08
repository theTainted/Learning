package com.learning.tests;

import pageobjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Syam on 27-10-2015.
 */
public class TestAddItemsToBasket {

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
                }
            /* else if (browser.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver",
                        "D:/Dev/Jars/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }*/

            } catch (WebDriverException e) {
                System.out.println(e.getMessage());
            }
        }
        @Test
        public void testAddItemsToBasket() throws Exception {
            driver.get("http://uat-annoushka.tryzensprojects.com/uk/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("cookienotice-close-button")).click();


            HomePage homePage = PageFactory.initElements(driver, HomePage.class);
          //  homePage.clickOnHeaderSearchIcon();
            homePage.enterSearchText("Search");

            homePage.clickSearchButton(driver,"Search");

        }


     /*   @AfterClass
        public void closeBrowser(){
            driver.quit();
        }*/
    }



