package resources.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import resources.runner.TestRunner;

public class HandlerLeaderboardSteps {

    @Given("the handler is already logged into the handler page")
    public void the_handler_is_already_logged_into_the_handler_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.get("C:\\Users\\itsvi\\Documents\\GitHub\\Project-2\\website Project_2\\Shield Website\\shield_html\\shield_handler.html");
    }

    @When("the handler clicks on the leaderboard button they will see the information")
    public void the_handler_clicks_on_the_leaderboard_button_they_will_see_the_information() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.handlerLeaderboard.link1.click();
    }

    @Then("the information will be displayed on the handler page")
    public void the_information_will_be_displayed_on_the_handler_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.explicitWait.until(ExpectedConditions.titleIs("Shield Handler"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Shield Handler");
    }
}
