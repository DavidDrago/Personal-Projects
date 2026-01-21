package PageObjectModel.demoqa.AlertsFrameWindows;

import PageObjectModel.demoqa.HomePage;
import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElementJS;

public class AlertsFrameWindowsPage extends HomePage {
    private By modalDialogs = By.xpath("//li[@id='item-4']/span[text()='Modal Dialogs']");
    private By alerts = By.xpath("//li[@id='item-1']/span[text()='Alerts']");
    private By frames = By.xpath("//li[@id='item-2']/span[text()='Frames']");
    private By windows = By.xpath("//li[@id='item-0']/span[text()='Browser Windows']");

    public ModalDialogsPage clickModalDialogs(){
        scrollToElementJS(modalDialogs);
        click(modalDialogs);
        return new ModalDialogsPage();
    }

    public AlertsPage clickAlerts(){
        scrollToElementJS(alerts);
        click(alerts);
        return new AlertsPage();
    }

    public FramesPage clickFrames(){
        scrollToElementJS(frames);
        click(frames);
        return new FramesPage();
    }

    public WindowsPage clickWindows(){
        scrollToElementJS(windows);
        click(windows);
        return new WindowsPage();
    }
}
