package SeleniumTestingUsingPageObjectModel.Tests;

import PageObjectModel.BasePage;
import PageObjectModel.LoginPage;
import SeleniumTestingUsingPageObjectModel.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginErrorMessage(){
        loginPage.setUsername("admin");
        loginPage.setPassword("admin");
        loginPage.clickLogin();
        String actualResult = loginPage.getErrorMessage();
        Assert.assertTrue(actualResult.contains("Invalid username or password. Please try again."));
    }
}
