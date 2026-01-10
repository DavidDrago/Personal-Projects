package PageObjectModel.demoqa.Elements;

import PageObjectModel.demoqa.HomePage;
import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElementJS;

public class ElementsPage extends HomePage {
    private By webTables = By.xpath("//li[@id='item-3']/span[text()='Web Tables']");
    private By links = By.xpath("//li[@id='item-5']/span[text()='Links']");

    public WebTablesPage clickWebTables(){
        scrollToElementJS(webTables);
        click(webTables);
        return new WebTablesPage();
    }

    public LinksPage clickLinks(){
        scrollToElementJS(links);
        click(links);
        return new LinksPage();
    }
}
