package SeleniumTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.qaplayground.com/bank");
    }

    @Test
    public void LoginTest() throws InterruptedException {
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");

        var password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        driver.findElement(By.id("login-btn")).click();

        Thread.sleep(1000);

        String actualResult = driver.findElement(By.id("username-display")).getText();
        String expectedResult = "admin";

        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(3000);
    }

    @Test
    public void LoginTestShouldFail() throws InterruptedException {
        driver.findElement(By.id("logout-btn")).click();
        driver.switchTo().alert().accept();

        Thread.sleep(3000);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");

        var password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        driver.findElement(By.id("login-btn")).click();

        Thread.sleep(1000);

        String actualResult = driver.findElement(By.id("username-display")).getText();
        String expectedResult = "user";

        Assert.assertNotEquals(actualResult, expectedResult);

        Thread.sleep(3000);
    }


    @AfterClass
    public void cleanup(){
        driver.quit();
    }

}
