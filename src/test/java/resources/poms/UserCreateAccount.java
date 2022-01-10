package resources.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCreateAccount {
    private WebDriver driver;

    public UserCreateAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "linkCreateAccount")
    public WebElement createAccountLink;
    @FindBy(id = "createAccountFirstName")
    public WebElement createAccountFirstName;
    @FindBy(id = "createAccountLastName")
    public WebElement createAccountLastName;
    @FindBy(id = "createAccountUsername")
    public WebElement createAccountUsername;
    @FindBy(id = "createAccountPassword")
    public WebElement createAccountPassword;
    @FindBy(id = "createAccountConfirmPassword")
    public WebElement createAccountConfirmPassword;
    @FindBy(id = "createAccountButton")
    public WebElement createAccountButton;
}
