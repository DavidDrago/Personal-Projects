package SeleniumTestingUsingPageObjectModel.qaplayground.Tests;

import PageObjectModel.qaplayground.BankPage;
import SeleniumTestingUsingPageObjectModel.qaplayground.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankTests extends BaseTest {

    @Test
    public void testBankNameIsDisplayed() throws InterruptedException {
        BankPage bankPage = loginPage.LoginIntoApplication("admin", "admin123");
        Thread.sleep(1000);
        Assert.assertTrue(bankPage.isBankNameDisplayed(), "Bank Name is not visible, Login might have failed");
    }
}
