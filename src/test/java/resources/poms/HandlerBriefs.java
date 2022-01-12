package resources.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HandlerBriefs {

    private WebDriver driver;

    public HandlerBriefs(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "claimEmployeeArrow")
    public WebElement link1;
    @FindBy(id = "employee2")
    public WebElement link2;
    @FindBy(id = "viewDebriefsButton")
    public WebElement link3;

}
