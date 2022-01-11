package resources.runner;

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
import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/features", glue ="resources/steps")
// Absolute Path and Content Root worked
public class TestRunner {
    public static WebDriver driver;
    public static UserLogin userLogin;
    public static UserLogout userLogout;
    public static AgentLogin agentLogin;
    public static AgentLogout agentLogout;
    public static UserCreateClaim userCreateClaim;
    public static UserCreateAccount userCreateAccount;
    public static UserViewClaims userViewClaims;
    public static WebDriverWait explicitWait;



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
        userCreateAccount = new UserCreateAccount(driver);
        userViewClaims = new UserViewClaims(driver);
        System.out.println("setup complete!");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        explicitWait = new WebDriverWait(driver, 5);

    }
    @AfterClass
    public static void teardown(){
        driver.quit();
        System.out.println("teardown complete!");
    }
}
