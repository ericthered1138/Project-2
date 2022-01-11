package resources.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCreateClaim {
    private WebDriver driver;

    public UserCreateClaim(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "newClaimButton")
    public WebElement newClaimButton;
    @FindBy(id = "claimEmployeeDropdown")
    public WebElement claimEmployeeDropdown;
    @FindBy(id = "employee2")
    public WebElement employeeFromDropdown;
    @FindBy(id = "claimAmount")
    public WebElement claimAmountInput;
    @FindBy(id = "claimDescription")
    public WebElement claimDescriptionInput;
    @FindBy(id = "claimLocation")
    public WebElement claimLocationInput;
    @FindBy(id = "claimDate")
    public WebElement claimDateInput;
    @FindBy(id = "submitNewClaimButton")
    public WebElement submitNewClaimButton;

}
