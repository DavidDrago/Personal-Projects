package SeleniumTestingUsingPageObjectModel.demoqa.Base;

import PageObjectModel.demoqa.HomePage;
import PageObjectModel.Base.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

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
    }

    @BeforeMethod
    public void loadApplication(){
        driver.get(Url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        homePage = new HomePage();
        setUtilityDriver();
    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
    }
}
