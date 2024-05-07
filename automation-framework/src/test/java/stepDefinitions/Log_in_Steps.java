package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

public class Log_in_Steps extends Base_PO {

    private Login_PO login_po;

    public Log_in_Steps (Login_PO login_po){
        this.login_po = login_po;
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        login_po.navigateTo_WebDriverUniversity_Login_Page();
    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username) {
        login_po.setUsername(username);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        login_po.setPassword(password);
    }
    @And("I click on the Login button")
    public void i_click_on_the_login_button() {
        login_po.clickOn_Login_Button();
    }

    @Then("I should be presented with a validation successful login message")
    public void i_should_be_presented_with_a_validation_successful_log_in_message() {
    login_po.validate_SuccessfulLogin_Message();

    }

    @Then("I should be presented with a validation failed login message")
    public void i_should_be_presented_with_a_validation_failed_log_in_message() {
       login_po.validate_FailedLogin_Message();
    }

    @Then("I should be presented with the following validation login message {}")
    public void i_should_be_presented_with_the_following_validation_login_message(String expectedMessage) {
       waitForAlert_And_ValidateText(expectedMessage);
    }

}
