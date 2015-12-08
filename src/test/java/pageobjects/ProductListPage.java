package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Syam on 02-12-2015.
 */
public  class ProductListPage {
public WebDriver driver;

 //   @FindBy(xpath="//div[@id='search-query-wrapper']/h1")
    @FindBy(id="search-query-wrapper")
    public WebElement searchResultHeading;

    public String sText="text";

public ProductListPage(WebDriver driver){
    this.driver=driver;
}
}