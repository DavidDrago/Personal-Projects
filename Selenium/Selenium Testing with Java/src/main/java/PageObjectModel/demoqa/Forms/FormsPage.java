package PageObjectModel.demoqa.Forms;

import PageObjectModel.demoqa.HomePage;
import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElement;
import static Utilities.Utilities.delay;

public class FormsPage extends HomePage {
    private By practiceForm = By.xpath("//li[@id='item-0']/span[text()='Practice Form']");

    public PracticeFormPage clickPracticeForm(){
        scrollToElement(practiceForm);
        //delay(1000);
        click(practiceForm);
        //delay(1000);
        return new PracticeFormPage();
    }


}
