package PageObjectModel.demoqa.Elements;

import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElementJS;
import static Utilities.Utilities.delay;

public class LinksPage extends ElementsPage{
    private By badRequestLink = By.id("bad-request");
    private By linkResponse = By.id("linkResponse");

    public void clickBadRequestLink(){
        scrollToElementJS(badRequestLink);
        click(badRequestLink);
    }

    public  String getResponse(){
        delay(1000);
        return find(linkResponse).getText();
    }
}
