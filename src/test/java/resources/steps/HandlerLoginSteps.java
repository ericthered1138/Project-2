package resources.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import resources.runner.TestRunner;

import java.io.File;

public class HandlerLoginSteps {

    @Given("The handler is on login page")
    public void the_handler_is_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
        File f = new File("website Project_2/Shield Website/index.html");
        TestRunner.driver.get(f.getAbsolutePath());
    }

    @When("The handler enters their username in the username input box")
    public void the_handler_enters_their_username_in_the_username_input_box() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.agentLogin.link1.sendKeys("username");
    }

    @When("The handler enters their password in the password input box")
    public void the_handler_enters_their_password_in_the_password_input_box() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.agentLogin.link2.sendKeys("password");
    }

    @When("The handler clicks on the Sign In button")
    public void the_handler_clicks_on_the_sign_in_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.agentLogin.link3.click();
    }

    @Then("The user should be logged in and redirected to the handler home page")
    public void the_user_should_be_logged_in_and_redirected_to_the_handler_home_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.explicitWait.until(ExpectedConditions.titleIs("Shield Handler"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Shield Handler" );
    }
}
