package pageobjects;

import com.learning.functions.DB;
import org.openqa.selenium.*;
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
   //added this to avoid stale element exception
    boolean result = false;
        int attempt =0;
      WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='product-content']/div[@class='product-variations']//li[@class='attribute variant-dropdown']//a[@class='ffSelectButton']")));

        while (attempt <10){
            try{
                System.out.println(sizeDropDown.isDisplayed());
                sizeDropDown.click();
                System.out.println("attempt: "+attempt);
                result = true;
                break;
            }
            catch (StaleElementReferenceException e){

            }
            attempt++;
        }



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
    public void clickOnAddToBasket(WebDriver driver)throws Exception {
        //System.out.println("i came here");
        /*try{
          //  System.out.println("i came here to try");
            addToCart.isEnabled();
            System.out.println("addToCart: "+addToCart.isEnabled());
           WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart")));
           
            //Thread.sleep(5000);

            addToCart.click();
        }
        catch (ElementNotVisibleException e){
            Reporter.log("add to cart is not enabled.");
            System.out.println();
            e.printStackTrace();
        }*/
        boolean result = false;
        int attempt =0;
        while (attempt <10){
            try{
                System.out.println(addToCart.isEnabled());
                addToCart.click();
                System.out.println("attempt: "+attempt);
                result = true;
                break;
            }
            catch (StaleElementReferenceException e){

            }
            attempt++;
        }

    }

}
/* stale element exception issue this might resolve pseudocode
new WebDriverWait(driver, timeout)
    .ignoring(StaleElementReferenceException.class)
    .until(new Predicate<WebDriver>() {
        @Override
        public boolean apply(@Nullable WebDriver driver) {
            driver.findElement(By.id("checkoutLink")).click();
            return true;
        }
    });
 */