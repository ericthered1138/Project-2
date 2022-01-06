package resources.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.poms.EmployeeLogin;

import java.io.File;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/features", glue ="resources/steps")
// Absolute Path and Content Root worked
public class TestRunner {
    public static WebDriver driver;
    public static EmployeeLogin employeeLogin;
    public static WebDriverWait explicitWait;

    @BeforeClass
    public static void setup(){
        File file = new File("src/test/java/resources/features/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        employeeLogin = new EmployeeLogin(driver);
        System.out.println("setup complete!");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        explicitWait = new WebDriverWait(driver, 5);

    }
    @AfterClass
    public static void teardown(){
        driver.quit();
        System.out.println("teardown complete!");
    }
}
