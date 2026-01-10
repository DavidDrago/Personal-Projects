package PageObjectModel.demoqa.Forms;

import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElementJS;

public class PracticeFormPage extends FormsPage {
    private By femaleRadioButton = By.id("gender-radio-2");
    private By sportsHobbyCheckBox = By.id("hobbies-checkbox-1");
    private By readingHobbyCheckBox = By.id("hobbies-checkbox-2");
    private By musicHobbyCheckBox = By.id("hobbies-checkbox-3");


    public void enableMusicHobbyCheckBox(){
        if(!find(musicHobbyCheckBox).isSelected()){
            scrollToElementJS(musicHobbyCheckBox);
            click(musicHobbyCheckBox);
        }
    }

    public void enableSportsHobbyCheckBox(){
        if(!find(sportsHobbyCheckBox).isSelected()){
            scrollToElementJS(sportsHobbyCheckBox);
            click(sportsHobbyCheckBox);
        }
    }

    public void enableReadingHobbyCheckBox(){
        if(!find(readingHobbyCheckBox).isSelected()){
            scrollToElementJS(readingHobbyCheckBox);
            click(readingHobbyCheckBox);
        }
    }

    public void disableReadingHobbyCheckBox(){
        if(find(readingHobbyCheckBox).isSelected()){
            scrollToElementJS(readingHobbyCheckBox);
            click(readingHobbyCheckBox);
        }
    }

    public void clickFemaleRadioButton(){
        scrollToElementJS(femaleRadioButton);
        click(femaleRadioButton);
    }

    public boolean isFemaleSelected(){
        return find(femaleRadioButton).isSelected();
    }

    public  boolean isMusicHobbySelected(){
        return find(musicHobbyCheckBox).isSelected();
    }

    public  boolean isSportsHobbySelected(){
        return find(sportsHobbyCheckBox).isSelected();
    }

    public  boolean isReadingHobbySelected(){
        return find(readingHobbyCheckBox).isSelected();
    }
}
