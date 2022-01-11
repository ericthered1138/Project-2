package resources.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import resources.runner.TestRunner;

import static resources.runner.TestRunner.driver;

public class InvalidLoginUsernameOrPasswordSteps {
    @When("The user enters their {string} in the username input box")
    public void the_user_enters_their_abc_in_the_username_input_box(String username) {
        TestRunner.userLogin.link1.sendKeys(username);
    }
    @When("The user enters their {string} in the password input box")
    public void the_user_enters_their_david_in_the_password_input_box(String password) {
        TestRunner.userLogin.link2.sendKeys(password);
    }
    @Then("There is an alert telling the user that the login information is incorrect")
    public void there_is_an_alert_telling_the_user_that_the_login_information_is_incorrect() {
        TestRunner.explicitWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        String message = "Invalid username or password";
        if(alertMessage.equals(message)) {
            alert.accept();
        }
    }
}
