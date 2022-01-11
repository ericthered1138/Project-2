package resources.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import resources.runner.TestRunner;

import static resources.runner.TestRunner.driver;

public class UserInvalidClaimSteps {

    @When("the user inputs a negative amount into the amount input")
    public void the_user_inputs_a_negative_amount_into_the_amount_input() {
        TestRunner.userCreateClaim.claimAmountInput.sendKeys("-50");
    }
    @Then("the user is given an alert that his claim was invalid")
    public void the_user_is_given_an_alert_that_his_claim_was_invalid() {
        TestRunner.explicitWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        String message = "Invalid claim. Please check your inputs.";
        if(alertMessage.equals(message)) {
            alert.accept();
        }

    }
}
