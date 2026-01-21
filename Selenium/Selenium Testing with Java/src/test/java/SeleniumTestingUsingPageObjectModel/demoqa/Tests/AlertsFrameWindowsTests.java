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
        delay(1000);
        String title = modalDialogsPage.getSmallModalTitle();
        modalDialogsPage.closeSmallModal();
        Assert.assertEquals(title, "Small Modal");
    }

    @Test
    public void testInformationAlerts(){
        var alertsPage = homePage.goToAlertsFrameWindows().clickAlerts();
        alertsPage.clickInformationAlertButton();
        Assert.assertEquals(alertsPage.getAlertText(), "You clicked a button");
        alertsPage.acceptAlert();
    }

    @Test
    public void testConfirmAlertBox(){
        var alertsPage = homePage.goToAlertsFrameWindows().clickAlerts();
        alertsPage.clickConfirmAlertBoxButton();
        alertsPage.acceptAlert();
        Assert.assertEquals(alertsPage.getConfirmBoxResult(), "You selected Ok");
        alertsPage.clickConfirmAlertBoxButton();
        alertsPage.dismissAlert();
        Assert.assertEquals(alertsPage.getConfirmBoxResult(), "You selected Cancel");
    }

    @Test
    public void testPromptAlertBox(){
        var alertsPage = homePage.goToAlertsFrameWindows().clickAlerts();
        alertsPage.clickPromptAlertBoxButton();
        alertsPage.sendTextToPromptAlertBox("Yo Kiddo");
        alertsPage.acceptAlert();
        Assert.assertEquals(alertsPage.getPromptBoxResult(), "You entered Yo Kiddo");
    }

    @Test
    public void testFrames(){
        var framesPage = homePage.goToAlertsFrameWindows().clickFrames();
        framesPage.switchToBigFrame();
        Assert.assertEquals(framesPage.getSampleHeading(), "This is a sample page");
        switchToParentFrame();
        Assert.assertEquals(framesPage.getFramesHeader(), "Frames");
        framesPage.switchToSmallFrame();
        delay(1000);
        Assert.assertEquals(framesPage.getSampleHeading(), "This is a sample page");
        switchToDefaultContent();
        Assert.assertEquals(framesPage.getFramesHeader(), "Frames");
    }

    @Test
    public void testWindows(){
        var windowsPage = homePage.goToAlertsFrameWindows().clickWindows();
        windowsPage.clickOnNewWindow();
        windowsPage.switchToNewTabOrWindow();
        Assert.assertEquals(windowsPage.getSimpleHeading(),"This is a sample page");
        Assert.assertEquals(windowsPage.getCurrentURL(),"https://demoqa.com/sample");
        windowsPage.closeCurrentWindow();
        Assert.assertEquals(windowsPage.getWindowsHeader(), "Browser Windows");
        windowsPage.clickOnNewTab();
        windowsPage.switchToNewTabOrWindow();
        Assert.assertEquals(windowsPage.getSimpleHeading(),"This is a sample page");
        Assert.assertEquals(windowsPage.getCurrentURL(),"https://demoqa.com/sample");
        windowsPage.closeCurrentWindow();
        Assert.assertEquals(windowsPage.getWindowsHeader(), "Browser Windows");
    }
}
