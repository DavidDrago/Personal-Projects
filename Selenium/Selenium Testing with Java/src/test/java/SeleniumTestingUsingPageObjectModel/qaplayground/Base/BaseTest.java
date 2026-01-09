package SeleniumTestingUsingPageObjectModel.qaplayground.Base;

import PageObjectModel.Base.BasePage;
import PageObjectModel.qaplayground.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    private String Url = "https://www.qaplayground.com/bank";

    @BeforeClass
    public void setUp(){
        // Support for Brave Browser
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(Url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();
    }

    @AfterClass
    public  void cleanUp(){
        driver.quit();
    }
}
