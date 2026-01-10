package PageObjectModel.demoqa.Forms;

import PageObjectModel.demoqa.HomePage;
import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElementJS;

public class FormsPage extends HomePage {
    private By practiceForm = By.xpath("//li[@id='item-0']/span[text()='Practice Form']");

    public PracticeFormPage clickPracticeForm(){
        scrollToElementJS(practiceForm);
        click(practiceForm);
        return new PracticeFormPage();
    }
}
