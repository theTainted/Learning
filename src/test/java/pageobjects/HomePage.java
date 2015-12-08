package pageobjects;


import com.learning.functions.DB;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * Created by Syam on 11-10-2015.
 */
public class HomePage {
    public String sCategory;
     public String sSubCategory;
    public  WebDriver driver;


    @FindBy(xpath ="//form[@name='simpleSearch']//input[@id='q']")
    public WebElement searchTextBox;

    @FindBy(xpath="//input[@type='submit'][@value='go']")
    public WebElement searchButton;

    @FindBy(id="mini-cart")
    public WebElement miniBasket;

    /*@FindBy(id="search-query-wrapper")
    public WebElement searchResultHeading;*/

    /*--------------------------------------------------------------------------------------*/

    public void enterSearchText(String sTestCaseID) throws Exception {
        System.out.println(searchTextBox.isEnabled());
        String sSearchText = DB.GetData("login", "TestCaseID", sTestCaseID, "searchTerm");
        System.out.println(sSearchText);
        //    Reporter.log(sSearchText);

        searchTextBox.sendKeys(sSearchText);

    }

    public void clickSearchButton(WebDriver driver,String sTestCaseID)throws Exception {
        searchButton.click();
        ProductListPage PLP = PageFactory.initElements(driver,ProductListPage.class);
        String sExpectedSearchText=DB.GetData("login", "TestCaseID", sTestCaseID, "searchTerm");
        System.out.println("obj0: "+PLP);

      //  System.out.println("obj: "+PLP.sText);
    /*  System.out.println("pLP is :"+PLP.searchResultHeading.getText());
        if (sExpectedSearchText==(PLP.searchResultHeading.getText())){

            Reporter.log("the search string and result string matches");
        }
        else {
            Reporter.log("the search and result string dont match and the result string is " + PLP.searchResultHeading.getText());
        }*/


    }
    public void hoverOverMiniBasket(){
        Actions actions = new Actions(driver);
        actions.moveToElement(miniBasket);
        WebElement checkOutLink = driver.findElement(By.partialLinkText("mini-cart-link-checkout"));
        actions.moveToElement(checkOutLink);
        actions.click().build().perform();

        //mini-cart-link-checkout
    }
    }
