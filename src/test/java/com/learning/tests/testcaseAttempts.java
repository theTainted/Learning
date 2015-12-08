package com.learning.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Syam on 25-10-2015.
 */
public class testcaseAttempts {
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
    public void testMouseHover() throws Exception {
        driver.get("http://uat-annoushka.tryzensprojects.com/uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("cookienotice-close-button")).click();

        /*Actions actions = new Actions(driver);
      WebElement mainMenu = driver.findElement(By.xpath("//nav[@id='nav']/ul[@class='nav-primary']//a[contains(text(),'Jewellery')]"));
        System.out.println(mainMenu.getText());

       actions.moveToElement(mainMenu).build().perform();
      Thread.sleep(1000);
        List<WebElement> we = driver.findElements(By.xpath("//nav[@id='nav']/ul//div[@class='drop']/div[@class='inner-wrap']//div[@class='nav-column']/ul[@class='level1']//a"));

        for (WebElement W :we){

            System.out.println(W.getText());
        }

        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.hoverOverCategoryAndClickSubCategory(driver);*/

    }


   @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}

