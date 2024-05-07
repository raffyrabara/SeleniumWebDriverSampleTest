package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Vars;

public class Login_PO extends Base_PO{
    private @FindBy(id = "text")
    WebElement username_TextField;

    private @FindBy(id = "password")
    WebElement password_TextField;

    private @FindBy(id = "login-button")
    WebElement login_button;
    public Login_PO ()
    {
        super();
    }

    public void navigateTo_WebDriverUniversity_Login_Page(){
        navigateTo_URL(Global_Vars.WebDriver_Univ_Homepage_URL + "/Login-Portal/index.html?");
    }

    public void setUsername (String username)
    {
        sendKeys(username_TextField, username);
    }

    public void setPassword (String password)
    {
        sendKeys(password_TextField, password);
    }

    public void clickOn_Login_Button(){
        waitForWebElementAndClick(login_button);
    }
    public void validate_SuccessfulLogin_Message (){
        waitForAlert_And_ValidateText("validation succeeded");
    }

    public void validate_FailedLogin_Message (){
        waitForAlert_And_ValidateText("validation failed");
    }

}
