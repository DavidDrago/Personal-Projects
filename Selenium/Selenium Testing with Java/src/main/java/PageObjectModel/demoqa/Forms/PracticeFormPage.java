package PageObjectModel.demoqa.Forms;

import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElement;
import static Utilities.Utilities.delay;

public class PracticeFormPage extends FormsPage {
    private By femaleRadioButton = By.id("gender-radio-2");
    private By musicCheckBox = By.id("hobbies-checkbox-3");
    private By sportsCheckBox = By.id("hobbies-checkbox-1");

    public void enableMusicCheckBox(){
        scrollToElement(musicCheckBox);
        click(musicCheckBox);
        //delay(1000);
    }

    public void enableSportsCheckBox(){
        scrollToElement(sportsCheckBox);
        click(sportsCheckBox);
        //delay(1000);
    }

    public void clickFemaleRadioButton(){
        scrollToElement(femaleRadioButton);
        //delay(1000);
        click(femaleRadioButton);
        //delay(1000);
    }

    public boolean isFemaleSelected(){
        return find(femaleRadioButton).isSelected();
    }

    public  boolean isMusicEnabled(){
        return find(musicCheckBox).isSelected();
    }

    public  boolean isSportsEnabled(){
        return find(sportsCheckBox).isSelected();
    }
}
