package resources.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.runner.TestRunner;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AgentCreateDebrief {

//    @Given("the Agent is already logged in")
//    public void the_agent_is_already_logged_in(){
//        // Write code here that turns the phrase above into concrete actions
//        File f = new File("website Project_2/Shield Website/shield_html/shield_agent.html");
//        TestRunner.driver.get(f.getAbsolutePath());
//    }
    @When("the agent clicks on the button to start debrief form")
    public void the_agent_clicks_on_the_button_to_start_debrief_form() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.agentcreatedebrief.subButton));
        TestRunner.agentcreatedebrief.subButton.click();
    }
    @When("the agent enters text into the Debrief text box")
    public void the_agent_enters_text_into_the_debrief_text_box() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("debriefText")));
        TestRunner.agentcreatedebrief.debrieftext.sendKeys("I accidentally did take their stuff and use it for the avengers");
    }
    @When("the agent enters the date into the Date box")
    public void the_agent_enters_the_date_into_the_date_box() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.explicitWait.until(ExpectedConditions.visibilityOf(TestRunner.agentcreatedebrief.dateOfOccurrence));
        TestRunner.agentcreatedebrief.dateOfOccurrence.sendKeys("12152021");
    }
    @When("the agent enters a location into the location box")
    public void the_agent_enters_a_location_into_the_location_box() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.explicitWait.until(ExpectedConditions.visibilityOf(TestRunner.agentcreatedebrief.locationText));
        TestRunner.agentcreatedebrief.locationText.sendKeys("NYC");
    }
    @When("the agent clicks on the submit button")
    public void the_agent_clicks_on_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.agentcreatedebrief.submitButton));
        TestRunner.agentcreatedebrief.submitButton.click();
    }
    @Then("the agent will submit a new debrief case into the table")
    public void the_agent_will_submit_a_new_debrief_case_into_the_table() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.explicitWait.until(ExpectedConditions.titleIs("Shield Agent"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Shield Agent");
    }

}
