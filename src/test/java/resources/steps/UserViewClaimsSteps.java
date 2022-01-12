package resources.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import resources.runner.TestRunner;

import java.util.concurrent.TimeUnit;

public class UserViewClaimsSteps {

    @When("the user clicks on the review claims button")
    public void the_user_clicks_on_the_review_claims_button() {
        TestRunner.userViewClaims.reviewClaimButton.click();
    }

    @Then("the user can see previous claims")
    public void the_user_can_see_previous_claims() throws InterruptedException {
        TestRunner.userViewClaims.reviewClaimTable.getCssValue("display: block");
        TimeUnit.SECONDS.sleep(3);
    }
    @Then("the claims will be hidden")
    public void the_claims_will_be_hidden() throws InterruptedException {
        TestRunner.userViewClaims.reviewClaimTable.getCssValue("display: none");
        TimeUnit.SECONDS.sleep(1);
    }

}
