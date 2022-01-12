package resources.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import resources.runner.TestRunner;

import java.io.File;

public class HandlerApproveSteps {

    @Given("The handler is in the handler page")
    public void the_handler_is_in_the_handler_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.get("C:\\Users\\itsvi\\Documents\\GitHub\\Project-2\\website Project_2\\Shield Website\\shield_html\\shield_handler.html");
    }

    @When("the handler enter the claim id in the claim id input box")
    public void the_handler_enter_the_claim_id_in_the_claim_id_input_box() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.handlerApprove.link1.sendKeys("40");
    }

    @When("the handler enter the handler comment in the handler comment input box")
    public void the_handler_enter_the_handler_comment_in_the_handler_comment_input_box() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.handlerApprove.link2.sendKeys("??");
    }

    @When("the handler clicks the approve button")
    public void the_handler_clicks_the_approve_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.handlerApprove.link3.click();
    }

    @Then("a claim  is approved and sent to the previous claims and handler clicks on previous claims button to see update")
    public void a_claim_is_approved_and_sent_to_the_previous_claims_and_handler_clicks_on_previous_claims_button_to_see_update() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.handlerApprove.link4.click();

    }
}

//        TestRunner.explicitWait.until(ExpectedConditions.titleIs("Shield Handler"));
//        String title = TestRunner.driver.getTitle();
//        Assert.assertEquals(title, "Shield Handler" );
