package resources.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import resources.runner.TestRunner;

import static resources.runner.TestRunner.driver;

public class UserCreateAccountPasswordMismatchSteps {

    @When("the user enters a mismatching password into the confirm password box")
    public void the_user_enters_a_mismatching_password_into_the_confirm_password_box() {
        TestRunner.userCreateAccount.createAccountConfirmPassword.sendKeys("ec2");
    }
    @Then("the user is given an alert that the passwords do not match")
    public void the_user_is_given_an_alert_that_the_passwords_do_not_match() {
        TestRunner.explicitWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        String message = "Password does not match";
        if(alertMessage.equals(message)) {
            alert.accept();
        }
    }
}
