package resources.steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import resources.runner.TestRunner;

import java.util.concurrent.TimeUnit;

public class AgentViewDebriefs {
    @When("the Shield Agent clicks on the view Debrief button to display the Debriefs")
    public void the_shield_agent_clicks_on_the_view_debrief_button_to_display_the_debriefs() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.agentViewDebriefs.viewDebriefs));
        TestRunner.agentViewDebriefs.viewDebriefs.click();
    }
    @Then("the Shield Agent can see previous claims")
    public void the_user_can_see_previous_debriefs() throws InterruptedException{
        TestRunner.agentViewDebriefs.reviewDebriefTable.getCssValue("display: block");
        TimeUnit.SECONDS.sleep(3);
    }
    @Then("there is a table of previous Debriefings")
    public void there_is_a_table_of_previous_debriefings() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.agentViewDebriefs.reviewDebriefTable.getCssValue("display: none");
        TimeUnit.SECONDS.sleep(1);
    }
}
