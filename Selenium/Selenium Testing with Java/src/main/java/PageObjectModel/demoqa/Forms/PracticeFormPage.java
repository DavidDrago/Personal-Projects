package PageObjectModel.demoqa.Forms;

import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElement;
import static Utilities.Utilities.delay;

public class PracticeFormPage extends FormsPage {
    private By femaleRadioButton = By.id("gender-radio-2");

    public void clickFemaleRadioButton(){
        scrollToElement(femaleRadioButton);
        //delay(1000);
        click(femaleRadioButton);
        delay(3000);
    }

    public boolean isFemaleSelected(){
        return find(femaleRadioButton).isSelected();
    }
}
