package SeleniumTestingUsingPageObjectModel.demoqa.Tests;

import SeleniumTestingUsingPageObjectModel.demoqa.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utilities.SeleniumUtilities.tabSwitch;
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

    @Test
    public void testVisibleAfterSecondsButton(){
        var dynamicPropertiesPage = homePage.goToElements().clickDynamicProperties();
        Assert.assertEquals(dynamicPropertiesPage.getTextOfVisibleAfterButton(),"Visible After 5 Seconds");
    }

    @Test
    public void testButtons(){
        var buttonsPage = homePage.goToElements().clickButtons();
        buttonsPage.clickDoubleClickButton();
        Assert.assertTrue(buttonsPage.isDoubleClickMessageDisplayed());

        buttonsPage.clickRightClickButton();
        Assert.assertTrue(buttonsPage.isRightClickMessageDisplayed());

        buttonsPage.clickDynamicClickButton();
        Assert.assertTrue(buttonsPage.isDynamicClickMessageDisplayed());
    }

    @Test
    public void testTextBox(){
        var testBoxPage = homePage.goToElements().clickTextBox();
        testBoxPage.setUserName("David Drago");
        testBoxPage.setEmail("DavidDrago@castle.com");
        tabSwitch();
        testBoxPage.setCurrentAddress("151344th street");
        testBoxPage.setCurrentAddress("Modstat City");
        testBoxPage.setCurrentAddress("Teyvat Fantasy Realm");
        testBoxPage.clickSubmit();
        delay(1000);
        Assert.assertEquals(testBoxPage.getEmailOutput(), "Email:DavidDrago@castle.com");
    }
}
