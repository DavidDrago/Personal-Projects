package PageObjectModel.demoqa.Elements;

import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElementJS;
import static Utilities.SeleniumUtilities.*;

public class ButtonsPage extends ElementsPage{
    private By doubleClickButton = By.id("doubleClickBtn");
    private By rightClickButton = By.id("rightClickBtn");
    private By dynamicClickButton = By.xpath("//button[text()='Click Me']");
    private By doubleClickMessage = By.id("doubleClickMessage");
    private By rightClickMessage = By.id("rightClickMessage");
    private By dynamicClickMessage = By.id("dynamicClickMessage");

    public void clickDoubleClickButton(){
        doubleClick(find(doubleClickButton));
    }

    public void clickRightClickButton(){
        contextClick(find(rightClickButton));
    }

    public void clickDynamicClickButton(){
        click(dynamicClickButton);
    }

    public boolean isDoubleClickMessageDisplayed(){
        return isDisplayed(doubleClickMessage);
    }

    public boolean isRightClickMessageDisplayed(){
        return isDisplayed(rightClickMessage);
    }

    public boolean isDynamicClickMessageDisplayed(){
        return isDisplayed(dynamicClickMessage);
    }
}
