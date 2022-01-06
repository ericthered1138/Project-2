package resources.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import resources.runner.TestRunner;


public class EmployeeLoginSteps {

    @Given("The employee is on login page")
    public void the_employee_is_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.get("C:\\Users\\itsvi\\Desktop\\Project_2\\website Project_2\\Shield Website\\index.html");
    }

    @When("The employee enters their username in the username input box")
    public void the_employee_enters_their_username_in_the_username_input_box() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.employeeLogin.link1.sendKeys("david");
    }

    @When("The employee enters their password in the password input box")
    public void the_employee_enters_their_password_in_the_password_input_box() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.employeeLogin.link2.sendKeys("david");
    }

    @When("The employee clicks on the Sign In button")
    public void the_employee_clicks_on_the_Sign_In_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.employeeLogin.link3.click();
    }

    @Then("The employee should be logged in and redirected to the employee home page")
    public void the_employee_should_be_logged_in_and_redirected_to_the_employee_home_page() {
        // Write code here that turns the phrase above into concrete actions
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Login 10" );
    }

}
