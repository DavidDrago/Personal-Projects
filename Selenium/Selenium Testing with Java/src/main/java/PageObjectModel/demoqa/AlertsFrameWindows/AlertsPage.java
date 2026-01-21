package PageObjectModel.demoqa.AlertsFrameWindows;

import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElementJS;
import static Utilities.SeleniumUtilities.switchToAlert;

public class AlertsPage extends AlertsFrameWindowsPage{
    private By informationAlertButton = By.id("alertButton");
    private By confirmBoxButton = By.id("confirmButton");
    private By promptBoxButton = By.id(("promtButton"));
    private By confirmBoxResult = By.id("confirmResult");
    private By promptBoxResult = By.id("promptResult");

    public void clickInformationAlertButton(){
        scrollToElementJS(informationAlertButton);
        click(informationAlertButton);
    }

    public void clickConfirmAlertBoxButton(){
        scrollToElementJS(confirmBoxButton);
        click(confirmBoxButton);
    }

    public void clickPromptAlertBoxButton(){
        scrollToElementJS(promptBoxButton);
        click(promptBoxButton);
    }

    public String getAlertText(){
        return switchToAlert().getText();
    }

    public void acceptAlert(){
        switchToAlert().accept();
    }

    public void dismissAlert(){
        switchToAlert().dismiss();
    }

    public String getConfirmBoxResult(){
        return getText(confirmBoxResult);
    }

    public void sendTextToPromptAlertBox(String text){
        switchToAlert().sendKeys(text);
    }

    public String getPromptBoxResult(){
        return getText(promptBoxResult);
    }
}
