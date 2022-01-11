package resources.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentViewDebriefs {
    private WebDriver driver;

    public AgentViewDebriefs(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "viewDebriefs")
    public WebElement viewDebriefs;
    @FindBy(id = "debriefTable")
    public WebElement reviewDebriefTable;
}
