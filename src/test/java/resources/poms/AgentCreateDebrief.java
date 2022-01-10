package resources.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentCreateDebrief {
        private WebDriver driver;

        public AgentCreateDebrief(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver,this);
        }

        @FindBy(id = "subButton")
        public WebElement subButton;
        @FindBy(id = "debriefText")
        public WebElement debrieftext;
        @FindBy(id = "dateOfOccurrence")
        public WebElement dateOfOccurrence;
        @FindBy(id= "locationOfOccurrence")
        public WebElement locationText;
        @FindBy (id = "submitButton")
        public WebElement submitButton;
        }
