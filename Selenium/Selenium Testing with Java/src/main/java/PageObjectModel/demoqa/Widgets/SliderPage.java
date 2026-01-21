package PageObjectModel.demoqa.Widgets;

import org.openqa.selenium.By;

import static Utilities.SeleniumUtilities.dragAndDropBy;

public class SliderPage extends WidgetsPage{
    private By slider = By.xpath("//div[@id='sliderContainer']//input[@type='range']");
    private By sliderValue = By.id("sliderValue");

    public String getSliderValue(){
        return getAttribute(sliderValue, "value");
    }

    public void moveSlider(int x, int y){
        dragAndDropBy(find(slider), x, y);
    }
}
