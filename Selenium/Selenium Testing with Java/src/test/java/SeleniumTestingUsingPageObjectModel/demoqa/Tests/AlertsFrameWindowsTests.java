package SeleniumTestingUsingPageObjectModel.demoqa.Tests;

import SeleniumTestingUsingPageObjectModel.demoqa.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utilities.SeleniumUtilities.*;

public class AlertsFrameWindowsTests extends BaseTest {
    @Test
    public void testSmallModal(){

        var modalDialogsPage = homePage.goToAlertsFrameWindows().clickModalDialogs();
        modalDialogsPage.openSmallModal();
        String title = modalDialogsPage.getSmallModalTitle();
        modalDialogsPage.closeSmallModal();
        Assert.assertEquals(title, "Small Modal");
    }

    @Test
    public void testInformationAlerts(){
        var alertsPage = homePage.goToAlertsFrameWindows().clickAlertsPage();
        alertsPage.clickInformationAlertButton();
        Assert.assertEquals(alertsPage.getAlertText(), "You clicked a button");
        alertsPage.acceptAlert();
    }

    @Test
    public void testConfirmAlertBox(){
        var alertsPage = homePage.goToAlertsFrameWindows().clickAlertsPage();
        alertsPage.clickConfirmAlertBoxButton();
        alertsPage.acceptAlert();
        Assert.assertEquals(alertsPage.getConfirmBoxResult(), "You selected Ok");
        alertsPage.clickConfirmAlertBoxButton();
        alertsPage.dismissAlert();
        Assert.assertEquals(alertsPage.getConfirmBoxResult(), "You selected Cancel");
    }

    @Test
    public void testPromptAlertBox(){
        var alertsPage = homePage.goToAlertsFrameWindows().clickAlertsPage();
        alertsPage.clickPromptAlertBoxButton();
        alertsPage.sendTextToPromptAlertBox("Yo Kiddo");
        alertsPage.acceptAlert();
        Assert.assertEquals(alertsPage.getPromptBoxResult(), "You entered Yo Kiddo");
    }

    @Test
    public void testFrames(){
        var framesPage = homePage.goToAlertsFrameWindows().clickFramesPage();
        framesPage.switchToBigFrame();
        Assert.assertEquals(framesPage.getSimpleHeading(), "This is a sample page");
        switchToParentFrame();
        Assert.assertEquals(framesPage.getFramesHeader(), "Frames");
        framesPage.switchToSmallFrame();
        Assert.assertEquals(framesPage.getSimpleHeading(), "This is a sample page");
        switchToDefaultContent();
        Assert.assertEquals(framesPage.getFramesHeader(), "Frames");
    }
}
