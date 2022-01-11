package resources.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserViewClaims {

    private WebDriver driver;

    public UserViewClaims(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "reviewClaimButton")
    public WebElement reviewClaimButton;

    @FindBy(id = "claimTable")
    public WebElement reviewClaimTable;
}
