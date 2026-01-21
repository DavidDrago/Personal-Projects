package PageObjectModel.demoqa.Elements;

import PageObjectModel.demoqa.HomePage;
import org.openqa.selenium.By;

import java.awt.*;

import static Utilities.JavaScriptUtilities.scrollToElementJS;

public class ElementsPage extends HomePage {
    private By webTables = By.xpath("//li[@id='item-3']/span[text()='Web Tables']");
    private By links = By.xpath("//li[@id='item-5']/span[text()='Links']");
    private By dynamicProperties = By.xpath("//li[@id='item-8']/span[text()='Dynamic Properties']");
    private By buttons = By.xpath("//li[@id='item-4']/span[text()='Buttons']");
    private By textBox = By.xpath("//li[@id='item-0']/span[text()='Text Box']");

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

    public DynamicPropertiesPage clickDynamicProperties(){
        scrollToElementJS(dynamicProperties);
        click(dynamicProperties);
        return new DynamicPropertiesPage();
    }

    public ButtonsPage clickButtons(){
        scrollToElementJS(buttons);
        click(buttons);
        return new ButtonsPage();
    }

    public TextBoxPage clickTextBox(){
        scrollToElementJS(textBox);
        click(textBox);
        return new TextBoxPage();
    }
}
