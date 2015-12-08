package com.learning.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Syam on 30-10-2015.
 */
public class whistlesOrders {
    public static WebDriver driver;
    @Parameters({"browser"})
    @BeforeClass
    public void openBrowser(String browser) {
        //  WebDriver driver;

        try {
            if (browser.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
            }/* else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        "C:/chromedriver.exe");
                driver = new ChromeDriver();
            }*/
            /* else if (browser.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver"
                "D:/Dev/Jars/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }*/

        } catch (WebDriverException e) {
            System.out.println(e.getMessage());
        }
    }
 @Test
    public void placeOrders() throws Exception{
     driver.navigate().to("https://whistles.com");
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     driver.manage().window().maximize();
driver.findElement(By.className("closenewsletter")).click();
driver.findElement(By.xpath("//label[@for='cookiesCheckboxInput']")).click();
    /* System.out.println(driver.findElement(By.id("q")).isEnabled());
     WebElement searchBox = driver.findElement(By.id("q[1]"));
     WebElement searchBox = driver.findElement(By.xpath("//input[@id='q'][@class='valid']"));
     System.out.println(searchBox.isEnabled());
     searchBox.sendKeys("Syam");*/

     List<WebElement> textBoxes = driver.findElements(By.xpath("//input[@id='q'][@placeHolder='SEARCH']"));
     System.out.println(textBoxes.size());
     for (WebElement search:textBoxes){
         System.out.println(search.getText());
         System.out.println("value : "+search.getAttribute("value"));
         if(search.getAttribute("value")=="SEARCH"){
             search.sendKeys("Dress");
         }
        else{
             System.out.println("3g");
         }
     }


     }


 }

