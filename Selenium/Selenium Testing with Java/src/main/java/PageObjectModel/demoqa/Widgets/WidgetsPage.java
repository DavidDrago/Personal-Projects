package PageObjectModel.demoqa.Widgets;

import PageObjectModel.demoqa.HomePage;
import org.openqa.selenium.By;

import static Utilities.JavaScriptUtilities.scrollToElementJS;

public class WidgetsPage extends HomePage {
    private By selectMenu = By.xpath("//li[@id='item-8']/span[text()='Select Menu']");
    private By datePicker = By.xpath("//li[@id='item-2']/span[text()='Date Picker']");
    private By progressBar = By.xpath("//li[@id='item-4']/span[text()='Progress Bar']");
    private By slider = By.xpath("//li[@id='item-3']/span[text()='Slider']");

    public SelectMenuPage clickSelectMenu(){
        scrollToElementJS(selectMenu);
        click(selectMenu);
        return new SelectMenuPage();
    }

    public DatePickerPage clickDatePicker(){
        scrollToElementJS(datePicker);
        click(datePicker);
        return new DatePickerPage();
    }

    public ProgressBarPage clickProgressBar(){
        scrollToElementJS(progressBar);
        click(progressBar);
        return new ProgressBarPage();
    }

    public SliderPage clickSlider(){
        scrollToElementJS(slider);
        click(slider);
        return new SliderPage();
    }
}
