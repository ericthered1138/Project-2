package resources.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import resources.runner.TestRunner;

import static resources.runner.TestRunner.driver;

public class UsernameAlreadyTakenSteps {

    @When("the user enters a username that already exists into the create username box")
    public void the_user_enters_a_username_that_already_exists_into_the_create_username_box() {
        TestRunner.userCreateAccount.createAccountUsername.sendKeys("eric");
    }
    @Then("the user is given an alert that the username is taken")
    public void the_user_is_given_an_alert_that_the_username_is_taken() {
        TestRunner.explicitWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        String message = "Username is taken.";
        if(alertMessage.equals(message)) {
            alert.accept();
        }
    }
}
