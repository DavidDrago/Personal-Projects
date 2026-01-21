package SeleniumTestingUsingPageObjectModel.demoqa.Tests;

import SeleniumTestingUsingPageObjectModel.demoqa.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static Utilities.Utilities.delay;
import static java.lang.IO.println;

public class WidgetsTests extends BaseTest {
    @Test
    public void testStandardMultiSelectDropDown(){
        var selectMenuPage = homePage.goToWidgets().clickSelectMenu();
        selectMenuPage.selectStandardMulti("Volvo");
        selectMenuPage.selectStandardMulti(2);
        selectMenuPage.selectStandardMulti("Audi");
        selectMenuPage.selectStandardMulti(1);
        delay(1000);
        selectMenuPage.deselectStandardMulti("opel");
        delay(1000);

        List<String> selectedOptions = selectMenuPage.getAllSelectedStandardMultiOptions();
        Assert.assertTrue(selectedOptions.contains("Volvo") && selectedOptions.contains("Audi"));
        Assert.assertTrue(selectedOptions.contains("Saab") && !selectedOptions.contains("Opel"));
    }

    @Test
    public void testSelectDateInDatePicker(){
        var datePickerPage = homePage.goToWidgets().clickDatePicker();
        datePickerPage.clickSelectDate();
        delay(1000);
        datePickerPage.selectMonth("March");
        delay(1000);
        datePickerPage.selectYear("2000");
        delay(1000);
        datePickerPage.selectDay("9");
        delay(1000);

        Assert.assertEquals(datePickerPage.getDate(), "03/09/2000", "The actual & expected date doesn't match");
    }

    @Test
    public void testProgressBar(){
        var progressBarPage = homePage.goToWidgets().clickProgressBar();
        progressBarPage.clickStartButton();
        Assert.assertEquals(progressBarPage.getProgressValue(), "100%");
    }

    @Test
    public void testSlider(){
        var sliderPage = homePage.goToWidgets().clickSlider();
        int x = 0;
        int y = 0;
        for(int i=1;i<=100;i++){
            double valueX = -325+(i*6.5); // formula to map xoffset value to slider percentage
            sliderPage.moveSlider((int)valueX, y);
            Assert.assertEquals(sliderPage.getSliderValue(), String.valueOf(i));
            println("SliderValue: "+sliderPage.getSliderValue());
        }
    }
}
