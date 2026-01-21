package SeleniumTestingUsingPageObjectModel.demoqa.Base;

import PageObjectModel.demoqa.HomePage;
import PageObjectModel.Base.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static Utilities.Utilities.setUtilityDriver;

public class BaseTest {
    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private String Url = "https://demoqa.com/";

    @BeforeClass
    public void setUp(){
        // Support for Brave Browser
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        // driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void loadApplication(){
        driver.get(Url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        homePage = new HomePage();
        setUtilityDriver();
    }

    @AfterMethod
    public void takeScreenshotOfFailureTest(@NonNull ITestResult testResult){
        if (ITestResult.FAILURE == testResult.getStatus()){
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/" +
                    java.time.LocalDate.now() + testResult.getName() + ".png");

            try{
                FileHandler.copy(source, destination);
            } catch (IOException e){
                throw  new RuntimeException(e);
            }

            System.out.println("ScreenShot located at: " + destination);
        }
    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
    }
}
