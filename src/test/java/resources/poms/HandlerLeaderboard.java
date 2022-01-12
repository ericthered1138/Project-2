package resources.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HandlerLeaderboard {

    private WebDriver driver;

    public HandlerLeaderboard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "viewLeaderBoard")
    public WebElement link1;
    @FindBy(id = "employee2")
    public WebElement employeeFromDropdown;

}
