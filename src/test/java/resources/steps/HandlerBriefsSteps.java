package resources.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;
import resources.runner.TestRunner;

public class HandlerBriefsSteps {

    @Given("The handler is currently in the handler page")
    public void the_handler_is_currently_in_the_handler_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.get("C:\\Users\\itsvi\\Documents\\GitHub\\Project-2\\website Project_2\\Shield Website\\shield_html\\shield_handler.html");
    }

    @When("the user selects the employee dropdown menu on handler page")
    public void the_user_selects_the_employee_dropdown_menu_on_handler_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.handlerBriefs.link1.click();
    }

    @When("the user clicks on the employee in the dropdown menu on handler page")
    public void the_user_clicks_on_the_employee_in_the_dropdown_menu_on_handler_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.handlerBriefs.link2.click();
    }

    @Then("the handler clicks the view briefs button to see the briefs for that employee")
    public void the_handler_clicks_the_view_briefs_button_to_see_the_briefs_for_that_employee() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.handlerBriefs.link3.click();
    }
}
