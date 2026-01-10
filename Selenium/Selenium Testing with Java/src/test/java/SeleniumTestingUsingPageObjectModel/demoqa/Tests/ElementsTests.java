package SeleniumTestingUsingPageObjectModel.demoqa.Tests;

import SeleniumTestingUsingPageObjectModel.demoqa.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utilities.Utilities.delay;

public class ElementsTests extends BaseTest {

    @Test
    public void testWebTableToEditAge(){
        String email = "kierra@example.com";
        String age = "32";

        var webTablePage = homePage.goToElements().clickWebTables();
        webTablePage.clickEdit("kierra@example.com");
        delay(1000);
        webTablePage.setAge(age);
        delay(1000);
        webTablePage.clickSubmitButton();
        delay(1000);
        Assert.assertEquals(webTablePage.getTableAge("kierra@example.com"), age, "Actual & Expected ages doesn't Match, the update might have failed");
    }

    @Test
    public void testAddingNewRecord(){
        var webTablePage = homePage.goToElements().clickWebTables();
        webTablePage.clickAddButton();
        webTablePage.setFirstName("Dasari");
        webTablePage.setLastName("Akhil");
        webTablePage.setEmail("Dasari@example.com");
        webTablePage.setAge("26");
        webTablePage.setSalary("7000");
        webTablePage.setDepartment("Sales");
        delay(1000);
        webTablePage.clickSubmitButton();
        delay(1000);
        Assert.assertTrue(webTablePage.isFirstNameDisplayed("Dasari"),"Given FirstName is not displayed, New record might not have updated");
        Assert.assertTrue(webTablePage.isLastNameDisplayed("Akhil"), "Given LastName is not displayed, New record might not have updated");
        Assert.assertTrue(webTablePage.isEmailDisplayed("Dasari@example.com"),"Given Email is not displayed, New record might not have updated");
    }

    @Test
    public void testBadRequestLink(){
        var linkPage = homePage.goToElements().clickLinks();
        linkPage.clickBadRequestLink();
        String response = linkPage.getResponse();
        Assert.assertTrue(response.contains("400") && response.contains("Bad Request"), "Response doesn't match");
    }
}
