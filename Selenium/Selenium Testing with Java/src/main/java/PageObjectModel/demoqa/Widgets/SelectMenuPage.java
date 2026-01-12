package PageObjectModel.demoqa.Widgets;

import PageObjectModel.demoqa.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static Utilities.JavaScriptUtilities.scrollToElementJS;
import static Utilities.SeleniumUtilities.*;
import static Utilities.Utilities.delay;

public class SelectMenuPage extends WidgetsPage {
    private By standardMultiSelect = By.id("cars");

    public void selectStandardMulti(String text){
        scrollToElementJS(standardMultiSelect);
        selectByVisibleText(standardMultiSelect, text);
    }

    public void selectStandardMulti(int index){
        scrollToElementJS(standardMultiSelect);
        selectByIndex(standardMultiSelect, index);
    }

    public void deselectStandardMulti(String value){
        scrollToElementJS(standardMultiSelect);
        deselectByValue(standardMultiSelect, value);
    }

    public List<String> getAllSelectedStandardMultiOptions(){
        return getAllSelectedOptions(standardMultiSelect);
    }
}
