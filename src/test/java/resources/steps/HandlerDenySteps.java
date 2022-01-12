package resources.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.runner.TestRunner;

public class HandlerDenySteps {

    @Given("The handler is in the handler page to deny")
    public void the_handler_is_in_the_handler_page_to_deny() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.get("C:\\Users\\itsvi\\Documents\\GitHub\\Project-2\\website Project_2\\Shield Website\\shield_html\\shield_handler.html");
    }

    @When("the handler enter the claim id in the claim id input box to deny")
    public void the_handler_enter_the_claim_id_in_the_claim_id_input_box_to_deny() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.handlerApprove.link1.sendKeys("42");
    }

    @When("the handler enter the handler comment in the handler comment input box to deny")
    public void the_handler_enter_the_handler_comment_in_the_handler_comment_input_box_to_deny() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.handlerApprove.link2.sendKeys("??");
    }

    @When("the handler clicks the deny button")
    public void the_handler_clicks_the_deny_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.handlerDeny.link3.click();
    }

    @Then("a claim is denied and sent to the previous claims and handler clicks on previous claims button to see update")
    public void a_claim_is_denied_and_sent_to_the_previous_claims_and_handler_clicks_on_previous_claims_button_to_see_update() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.handlerDeny.link4.click();
    }
}
