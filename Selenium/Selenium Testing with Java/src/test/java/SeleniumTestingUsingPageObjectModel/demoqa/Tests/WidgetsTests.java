package SeleniumTestingUsingPageObjectModel.demoqa.Tests;

import SeleniumTestingUsingPageObjectModel.demoqa.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static Utilities.Utilities.delay;

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
}
