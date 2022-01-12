package resources.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HandlerLogout {
    private WebDriver driver;

    public HandlerLogout(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "logoutButton")
    public WebElement link1;
}
