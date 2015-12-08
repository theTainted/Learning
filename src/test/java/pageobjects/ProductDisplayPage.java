package pageobjects;

import com.learning.functions.DB;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;

/**
 * Created by Syam on 07-12-2015.
 */
public class ProductDisplayPage {
    WebDriver driver;


    @FindBy(xpath="//div[@id='product-content']/div[@class='product-variations']//li[@class='attribute variant-dropdown']//a[@class='ffSelectButton']")
    public WebElement sizeDropDown;
    @FindBy(xpath="//div[@id='product-content']/div[@class='product-variations']//li[@class='attribute variant-dropdown']//div[@class='ffSelect']//div[@class='ffSelectMenuMid']//li")
    public List<WebElement> sizeOptions;
    @FindBy(id="add-to-cart")
    public WebElement addToCart;

    public ProductDisplayPage(WebDriver driver){
        this.driver=driver;
    }
    public void setSize(String sTestCaseID) throws Exception{

        sizeDropDown.click();
        String sSize = DB.GetData("address","TestCaseID",sTestCaseID,"Size");
        List <WebElement> options=sizeOptions;
        for (WebElement o:options){
          if(o.getText().equals(sSize)){
          System.out.println("if");
          o.click();
       break;
      }
        }
    }
    public void clickOnAddToBasket(WebDriver driver) {
        //System.out.println("i came here");
        try{
          //  System.out.println("i came here to try");
            addToCart.isEnabled();
            //System.out.println("addToCart: "+addToCart.isEnabled());
            WebDriverWait wait = new WebDriverWait(driver,5);
           wait.until(ExpectedConditions.elementToBeClickable(addToCart));

            addToCart.click();
        }
        catch (ElementNotVisibleException e){
            Reporter.log("add to cart is not enabled.");
            System.out.println();
            e.printStackTrace();
        }
    }

}
