package resources.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.runner.TestRunner;

import java.util.concurrent.TimeUnit;

public class UserCreateClaimSteps {

    @When("the user clicks on the submit new claim button")
    public void the_user_clicks_on_the_submit_new_claim_button() {
        TestRunner.userCreateClaim.newClaimButton.click();
    }
    @When("the user selects the employee dropdown menu")
    public void the_user_selects_the_employee_dropdown_menu() {
        TestRunner.userCreateClaim.claimEmployeeDropdown.click();
    }
    @When("the user clicks on the employee in the dropdown menu")
    public void the_user_clicks_on_the_employee_in_the_dropdown_menu() {
        TestRunner.userCreateClaim.employeeFromDropdown.click();
    }
    @When("the user inputs an amount into the amount input")
    public void the_user_inputs_an_amount_into_the_amount_input() {
        TestRunner.userCreateClaim.claimAmountInput.sendKeys("123.50");
    }
    @When("the user inputs a description into the description input")
    public void the_user_inputs_a_description_into_the_description_input() {
        TestRunner.userCreateClaim.claimDescriptionInput.sendKeys("Selenium wants money");
    }
    @When("the user inputs a location into the location input")
    public void the_user_inputs_a_location_into_the_location_input() {
        TestRunner.userCreateClaim.claimLocationInput.sendKeys("Downtown New York");
    }
    @When("the user inputs a date from the date input")
    public void the_user_inputs_a_date_from_the_date_input() {
        TestRunner.userCreateClaim.claimDateInput.sendKeys("01072022");
    }
    @When("the user clicks on the submit button")
    public void the_user_clicks_on_the_submit_button() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        TestRunner.userCreateClaim.userHome.click();
        TimeUnit.SECONDS.sleep(2);
        TestRunner.userCreateClaim.submitNewClaimButton.click();
    }
    @Then("the claim is added to a table of claims")
    public void the_claim_is_added_to_a_table_of_claims() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "User Page");
    }


}