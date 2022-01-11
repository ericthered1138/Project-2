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
    @FindBy(id = "signUpFirstName")
    public WebElement createAccountFirstName;
    @FindBy(id = "signUpLastName")
    public WebElement createAccountLastName;
    @FindBy(id = "signUpUsername")
    public WebElement createAccountUsername;
    @FindBy(id = "signUpPassword")
    public WebElement createAccountPassword;
    @FindBy(id = "confirmSignUpPassword")
    public WebElement createAccountConfirmPassword;
    @FindBy(id = "createAccountButton")
    public WebElement createAccountButton;
}
