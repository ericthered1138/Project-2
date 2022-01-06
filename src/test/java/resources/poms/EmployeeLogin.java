package resources.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeLogin {
    private WebDriver driver;

    public EmployeeLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username")
    public WebElement link1;
    @FindBy(id = "password")
    public WebElement link2;
    @FindBy(id = "button")
    public WebElement link3;

}
