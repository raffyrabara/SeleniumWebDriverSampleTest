package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Global_Vars;

public class Contact_Us_PO extends Base_PO {

    private @FindBy(how = How.XPATH, using = "//input[@name ='first_name']" )
    WebElement firstName_TextField;

    private @FindBy(xpath = "//input[@name='last_name']" )
    WebElement lastName_TextField;

    private @FindBy(xpath = "//input[@placeholder='Email Address']" )
    WebElement emailAdd_TextField;

    private @FindBy(name = "message" )
    WebElement comment_TextField;

    private @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement submit_button;

    private @FindBy(xpath = "//div[@id='contact_reply']/h1")
    WebElement successful_Message_Text;
    public Contact_Us_PO(){
        super();
    }
    public void navigateTo_WebDriver_University_ContactUs_Page (){
        navigateTo_URL(Global_Vars.WebDriver_Univ_Homepage_URL + "/Contact-Us/contactus.html");
    }

    public void setUnique_FirstName (){
        sendKeys(firstName_TextField, "AutoFN"+ generateRandomNumber(5));
    }

    public void setUnique_LastName (){
        sendKeys(lastName_TextField, "AutoFN"+ generateRandomNumber(5));
    }

    public void setUnique_EmailAddress (){
        sendKeys(emailAdd_TextField, "autoemail"+ generateRandomNumber(6) +"@gmail.com");
    }

    public void setUnique_Comment (){
        sendKeys(comment_TextField, "hello how are you" + generateRandomNumber(20));
    }

    public void setSpecific_FirstName (String firstname){
        sendKeys(firstName_TextField, firstname);
    }

    public void setSpecific_LastName (String lastname){
        sendKeys(lastName_TextField, lastname);
    }

    public void setSpecific_EmailAddress (String emailAddress){
        sendKeys(emailAdd_TextField, emailAddress);
    }

    public void setSpecific_Comment (String specificComment){
        sendKeys(comment_TextField, specificComment);
    }

    public void clickOn_Submit_Button(){
        waitForWebElementAndClick(submit_button);
    }

    public void validate_Successful_SubmissionMessage_Text(){
        waitFor(successful_Message_Text);
        Assert.assertEquals(successful_Message_Text.getText(), "Thank You for your Message!");
    }

}
