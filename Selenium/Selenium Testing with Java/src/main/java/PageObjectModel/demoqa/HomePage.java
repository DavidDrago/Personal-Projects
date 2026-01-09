package PageObjectModel.demoqa;

import PageObjectModel.Base.BasePage;
import PageObjectModel.demoqa.Forms.FormsPage;
import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElement;
import static Utilities.Utilities.delay;

public class HomePage  extends BasePage {
    private By formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']");
    //private By formsCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div[3]/h5");

    public FormsPage goToForms(){
        scrollToElement(formsCard);
        //delay(1000);
        click(formsCard);
        //delay(1000);
        return new FormsPage();
    }
}
