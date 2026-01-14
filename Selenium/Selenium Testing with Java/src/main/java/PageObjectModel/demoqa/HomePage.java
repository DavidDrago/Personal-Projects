package PageObjectModel.demoqa;

import PageObjectModel.Base.BasePage;
import PageObjectModel.demoqa.AlertsFrameWindows.AlertsFrameWindowsPage;
import PageObjectModel.demoqa.Elements.ElementsPage;
import PageObjectModel.demoqa.Forms.FormsPage;
import PageObjectModel.demoqa.Widgets.WidgetsPage;
import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElementJS;

public class HomePage  extends BasePage {
    private By formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']");
    private By elementsCard = By.xpath("//div[@id='app']//h5[text()='Elements']");
    private By widgetsCard = By.xpath("//div[@id='app']//h5[text()='Widgets']");
    private By alertsFrameWindowsCard = By.xpath("//div[@id='app']//h5[text()='Alerts, Frame & Windows']");

    public FormsPage goToForms(){
        scrollToElementJS(formsCard);
        click(formsCard);
        return new FormsPage();
    }

    public ElementsPage goToElements(){
        scrollToElementJS(elementsCard);
        click(elementsCard);
        return new ElementsPage();
    }

    public WidgetsPage goToWidgets(){
        scrollToElementJS(widgetsCard);
        click(widgetsCard);
        return new WidgetsPage();
    }

    public AlertsFrameWindowsPage goToAlertsFrameWindows(){
        scrollToElementJS(alertsFrameWindowsCard);
        click(alertsFrameWindowsCard);
        return new AlertsFrameWindowsPage();
    }
}
