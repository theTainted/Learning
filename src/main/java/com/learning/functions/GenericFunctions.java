package com.learning.functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Syam on 12-10-2015.
 */
public class GenericFunctions {

    public Properties readFileData() {
        File file = new File("C:\\Users\\Syam\\IdeaProjects\\Learning\\src\\resources\\TESTDATA.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            System.out.println(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Check");
        }
        Properties prop = new Properties();
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

  /*  public void openBrowser(String browser) {
        WebDriver driver;

        try {
            if (browser.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        "C:/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver",
                        "D:/Dev/Jars/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }

        } catch (WebDriverException e) {
            System.out.println(e.getMessage());
        }
    }*/
}




