package resources.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.poms.AgentLogin;
import resources.poms.AgentLogout;
import resources.poms.UserLogin;
import resources.poms.UserLogout;

import java.io.File;
import java.time.Duration;
<<<<<<< HEAD
import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeUnit;
=======
>>>>>>> main

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/features", glue ="resources/steps")
// Absolute Path and Content Root worked
public class TestRunner {
    public static WebDriver driver;
    public static UserLogin employeeLogin;
    public static UserLogout userLogout;
    public static AgentLogin agentLogin;
    public static AgentLogout agentLogout;
    public static WebDriverWait explicitWait;

    @BeforeClass
    public static void setup(){
        File file = new File("src/test/java/resources/features/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        employeeLogin = new UserLogin(driver);
        userLogout = new UserLogout(driver);
        agentLogin = new AgentLogin(driver);
        agentLogout = new AgentLogout(driver);
        System.out.println("setup complete!");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
<<<<<<< HEAD
=======
        //noinspection deprecation
>>>>>>> main
        explicitWait = new WebDriverWait(driver, 5);

    }
    @AfterClass
    public static void teardown(){
        driver.quit();
        System.out.println("teardown complete!");
    }
}
