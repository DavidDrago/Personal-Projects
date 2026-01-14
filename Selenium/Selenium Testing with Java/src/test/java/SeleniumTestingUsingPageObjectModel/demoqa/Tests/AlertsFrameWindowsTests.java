package SeleniumTestingUsingPageObjectModel.demoqa.Tests;

import SeleniumTestingUsingPageObjectModel.demoqa.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utilities.Utilities.delay;

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
}
