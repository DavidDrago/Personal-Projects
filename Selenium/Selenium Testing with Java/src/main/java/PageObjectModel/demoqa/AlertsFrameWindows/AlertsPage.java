package PageObjectModel.demoqa.AlertsFrameWindows;

import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElementJS;
import static Utilities.SeleniumUtilities.switchToAlert;

public class AlertsPage extends AlertsFrameWindowsPage{
    private By informationAlertButton = By.id("alertButton");

    public void clickInformationAlertButton(){
        scrollToElementJS(informationAlertButton);
        click(informationAlertButton);
    }

    public String getAlertText(){
        return switchToAlert().getText();
    }

    public void acceptAlert(){
        switchToAlert().accept();
    }
}
