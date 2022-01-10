package resources.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import resources.runner.TestRunner;

import java.io.File;

public class AgentLogoutSteps {

    @Given("the Agent is already logged in")
    public void the_agent_is_already_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        File f = new File("website Project_2/Shield Website/index.html");
        TestRunner.driver.get(f.getAbsolutePath());
        TestRunner.employeeLogin.link1.sendKeys("scarlett");
        TestRunner.employeeLogin.link2.sendKeys("johansson");
        TestRunner.employeeLogin.link3.click();
        TestRunner.explicitWait.until(ExpectedConditions.titleIs("Shield Agent"));

    }

    @When("the agent clicks on the logout button")
    public void the_agent_clicks_on_the_logout_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.userLogout.link1.click();
    }

    @Then("the agent will return to the login page and have to log back in")
    public void the_agent_will_return_to_the_login_page_and_have_to_log_back_in() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.explicitWait.until(ExpectedConditions.titleIs("Shield Login"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Shield Login" );
    }
}
