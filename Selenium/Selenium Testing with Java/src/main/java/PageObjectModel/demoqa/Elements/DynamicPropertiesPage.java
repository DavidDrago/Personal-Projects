package PageObjectModel.demoqa.Elements;

import org.openqa.selenium.By;

import static Utilities.SeleniumUtilities.explicitWaitUntilVisible;

public class DynamicPropertiesPage extends ElementsPage{
    private By visibleAfterButton = By.id("visibleAfter");

    public String getTextOfVisibleAfterButton(){
        explicitWaitUntilVisible(5, visibleAfterButton);
        return getText(visibleAfterButton);
    }
}
