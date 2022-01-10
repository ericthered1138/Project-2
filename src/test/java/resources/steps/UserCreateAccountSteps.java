package resources.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import resources.runner.TestRunner;

import java.util.concurrent.TimeUnit;

import static resources.runner.TestRunner.driver;

public class UserCreateAccountSteps {

    @When("the user clicks the create account link")
    public void the_user_clicks_the_create_account_link() {
        TestRunner.userCreateAccount.createAccountLink.click();
    }
    @When("the user enters their first name into the first name box")
    public void the_user_enters_their_first_name_into_the_first_name_box() {
        TestRunner.userCreateAccount.createAccountFirstName.sendKeys("Jeff");
    }
    @When("the user enters their last name into the last name box")
    public void the_user_enters_their_last_name_into_the_last_name_box() {
        TestRunner.userCreateAccount.createAccountLastName.sendKeys("Bezos");
    }
    @When("the user enters a username into the create username box")
    public void the_user_enters_a_username_into_the_create_username_box() {
        TestRunner.userCreateAccount.createAccountUsername.sendKeys("Amazon");
    }
    @When("the user enters a password into the create password box")
    public void the_user_enters_a_password_into_the_create_password_box() {
        TestRunner.userCreateAccount.createAccountPassword.sendKeys("aws");
    }
    @When("the user enters the password into the confirm password box")
    public void the_user_enters_the_password_into_the_confirm_password_box() {
        TestRunner.userCreateAccount.createAccountConfirmPassword.sendKeys("aws");
    }
    @When("the user clicks the create account button")
    public void the_user_clicks_the_create_account_button() {
        TestRunner.userCreateAccount.createAccountButton.click();
    }
    @Then("there is a prompt saying the user account has been successfully created.")
    public void there_is_a_prompt_saying_the_user_account_has_been_successfully_created() throws InterruptedException {
        TestRunner.explicitWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        String message = "Successfully created account";
        if(alertMessage.equals(message)) {
            alert.accept();
        }
    }


}
