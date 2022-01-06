package resources.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import resources.runner.TestRunner;

public class AgentLoginSteps {

    @Given("The agent is on login page")
    public void the_agent_is_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.get("C:\\Users\\itsvi\\Documents\\GitHub\\Project-2\\website Project_2\\Shield Website\\index.html");
    }

    @When("The agent enters their username in the username input box")
    public void the_agent_enters_their_username_in_the_username_input_box() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.employeeLogin.link1.sendKeys("scarlett");
    }

    @When("The agent enters their password in the password input box")
    public void the_agent_enters_their_password_in_the_password_input_box() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.employeeLogin.link1.sendKeys("johansson");
    }

    @When("The agent clicks on the Sign In button")
    public void the_agent_clicks_on_the_sign_in_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.employeeLogin.link3.click();
    }

    @Then("The agent should be logged in and redirected to the agent home page")
    public void the_agent_should_be_logged_in_and_redirected_to_the_agent_home_page() {
        // Write code here that turns the phrase above into concrete actions
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Login 10" );
    }
}
