package PageObjectModel.demoqa.Widgets;

import PageObjectModel.demoqa.Elements.LinksPage;
import PageObjectModel.demoqa.HomePage;
import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElementJS;

public class WidgetsPage extends HomePage {
    private By selectMenu = By.xpath("//li[@id='item-8']/span[text()='Select Menu']");

    public SelectMenuPage clickSelectMenu(){
        scrollToElementJS(selectMenu);
        click(selectMenu);
        return new SelectMenuPage();
    }
}
