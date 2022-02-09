package resources.runner;

import com.shield.util.DatabaseTableCreator;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.poms.*;

import java.io.File;
import java.time.Duration;
//import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/features", glue ="resources/steps", plugin = {"pretty", "html:src/test/resources/reports/html-reports.html"})
// Absolute Path and Content Root worked
public class TestRunner {
    public static WebDriver driver;
    public static UserLogin userLogin;
    public static UserLogout userLogout;
    public static AgentLogin agentLogin;
    public static AgentLogout agentLogout;
    public static UserCreateClaim userCreateClaim;
    public static AgentCreateDebrief agentCreateDebrief;
    public static AgentViewDebriefs agentViewDebriefs;
    public static UserCreateAccount userCreateAccount;
    public static UserViewClaims userViewClaims;
    public static WebDriverWait explicitWait;
    public static HandlerLogin  handlerLogin;
    public static HandlerLogout handlerLogout;
    public static HandlerApprove handlerApprove;
    public static HandlerDeny handlerDeny;
    public static HandlerBriefs handlerBriefs;
    public static HandlerLeaderboard handlerLeaderboard;



    @BeforeClass
    public static void setup(){
        File file = new File("src/test/java/resources/features/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        userLogin = new UserLogin(driver);
        userLogout = new UserLogout(driver);
        agentLogin = new AgentLogin(driver);
        agentLogout = new AgentLogout(driver);
        userCreateClaim = new UserCreateClaim(driver);
        agentCreateDebrief = new AgentCreateDebrief(driver);
        agentViewDebriefs = new AgentViewDebriefs(driver);
        userCreateAccount = new UserCreateAccount(driver);
        userViewClaims = new UserViewClaims(driver);
        handlerLogin = new HandlerLogin(driver);
        handlerLogout = new HandlerLogout(driver);
        handlerApprove = new HandlerApprove(driver);
        handlerDeny = new HandlerDeny(driver);
        handlerBriefs = new HandlerBriefs(driver);
        handlerLeaderboard = new HandlerLeaderboard(driver);
        System.out.println("setup complete!");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        explicitWait = new WebDriverWait(driver, 5);

    }
    @AfterClass
    public static void teardown(){
        DatabaseTableCreator.delete_test_user();
        driver.quit();
        System.out.println("teardown complete!");
    }
}
