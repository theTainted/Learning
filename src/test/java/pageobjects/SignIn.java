package pageobjects;

import com.learning.functions.GenericFunctions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

/**
 * Created by Syam on 12-10-2015.
 */
public class SignIn {
private WebDriver driver;
    public SignIn(WebDriver driver){

        this.driver=driver;
    }
    public SignIn(){
        PageFactory.initElements(driver,SignIn.class);
    }


 @FindBy(id="send2")
    public WebElement signIn;
 @FindBy(className="logo")
    public WebElement logo;
 @FindBy(id="advice-required-entry-email")
    public WebElement emptyEmailIDError;
 @FindBy(id="email")
    public WebElement userName;


    public void clickOnSignIn(){

        signIn.click();
    }
    public void clickOnLogo(){

        logo.click();
    }
    public void assertErrorMessageForEmptyEmail(){
        SoftAssertions softAssertions = new SoftAssertions();
        String sText = emptyEmailIDError.getText();
        //System.out.println(sText);
        softAssertions.assertThat(sText);

        softAssertions.assertAll();
    }
    public void setUserName(){
        GenericFunctions genericFunctions = new GenericFunctions();
        Properties prop = genericFunctions.readFileData();
       // System.out.println(prop);
        System.out.println(prop.getProperty("emailId"));
        userName.sendKeys(prop.getProperty("emailId"));
 /* ResourceBundle r = ResourceBundle.getBundle("Learning.resources.TESTDATA");
        System.out.println(r);

       String  signInID = r.getString("emailId");
        System.out.println(signInID);
        userName.sendKeys(signInID);*/
    }
   // C:\Users\Syam\IdeaProjects\Learning\src\main\java\com\learning\pageobjects\TestData_en_IN.properties
}
