package SeleniumTestingUsingPageObjectModel.qaplayground.Tests;

import SeleniumTestingUsingPageObjectModel.qaplayground.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utilities.Utilities.delay;

public class LoginTests extends BaseTest {

    @FindBy(id = "username")
    WebElement username;

    @FindBy(how = How.ID, using = "password")
    WebElement password;

    @Test
    public void testLoginErrorMessage(){
        loginPage.setUsername("admin");
        loginPage.setPassword("admin");
        loginPage.clickLogin();
        String actualResult = loginPage.getErrorMessage();
        Assert.assertTrue(actualResult.contains("Invalid username or password. Please try again."));
    }

    @Test
    public void testLogin(){
        PageFactory.initElements(driver, this); // we need to initialize the pagefactory class to assign the driver to use.

        username.sendKeys("admin"); // driver.findElement(By.id("username")).sendKeys("admin");
        password.sendKeys("admin123"); // driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.id("login-btn")).click();
        delay(1000);
        Assert.assertEquals(driver.findElement(By.id("total-balance-title")).getText(), "Total Balance");
    }
}
