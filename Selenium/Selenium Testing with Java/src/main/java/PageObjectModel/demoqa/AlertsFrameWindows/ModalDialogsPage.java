package PageObjectModel.demoqa.AlertsFrameWindows;

import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElementJS;

public class ModalDialogsPage extends AlertsFrameWindowsPage{
    private By smallModalButton = By.id("showSmallModal");
    private By closeSmallModalButton = By.id("closeSmallModal");
    private By smallModalTitle = By.id("example-modal-sizes-title-sm");

    public void openSmallModal(){
        click(smallModalButton);
    }

    public void closeSmallModal(){
        click(closeSmallModalButton);
    }

    public String getSmallModalTitle(){
        return getText(smallModalTitle);
    }
}
