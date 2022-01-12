package resources.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HandlerApprove {

    private WebDriver driver;

    public HandlerApprove(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "claimIdInput")
    public WebElement link1;
    @FindBy(id = "handlerCommentInput")
    public WebElement link2;
    @FindBy(id = "Approvebutton")
    public WebElement link3;
    @FindBy(id = "previousclaimbutton")
    public WebElement link4;
}
