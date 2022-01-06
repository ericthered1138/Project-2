package resources.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import resources.runner.TestRunner;


public class UserLogoutSteps {

    @Given("the User is already logged in")
    public void the_user_is_already_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.get("C:\\Users\\itsvi\\Documents\\GitHub\\Project-2\\website Project_2\\Shield Website\\shield_html\\user.html");
    }

    @When("the user clicks on the logout button")
    public void the_user_clicks_on_the_logout_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.userLogout.link1.click();
    }

    @Then("the user will return to the login page and have to log back in")
    public void the_user_will_return_to_the_login_page_and_have_to_log_back_in() {
        // Write code here that turns the phrase above into concrete actions
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Login 10" );
    }
}
