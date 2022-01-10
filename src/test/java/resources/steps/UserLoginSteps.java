package resources.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import resources.runner.TestRunner;

import java.io.File;


public class UserLoginSteps {

    @Given("The user is on login page")
    public void the_employee_is_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
        File f = new File("website Project_2/Shield Website/index.html");
        TestRunner.driver.get(f.getAbsolutePath());
    }

    @When("The user enters their username in the username input box")
    public void the_employee_enters_their_username_in_the_username_input_box() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.employeeLogin.link1.sendKeys("david");
    }

    @When("The user enters their password in the password input box")
    public void the_employee_enters_their_password_in_the_password_input_box() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.employeeLogin.link2.sendKeys("david");
    }

    @When("The user clicks on the Sign In button")
    public void the_employee_clicks_on_the_Sign_In_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.employeeLogin.link3.click();
    }

    @Then("The user should be logged in and redirected to the user home page")
    public void the_employee_should_be_logged_in_and_redirected_to_the_employee_home_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.explicitWait.until(ExpectedConditions.titleIs("User Page"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "User Page" );
    }

}
