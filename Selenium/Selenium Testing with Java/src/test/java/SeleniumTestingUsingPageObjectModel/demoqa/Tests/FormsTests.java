package SeleniumTestingUsingPageObjectModel.demoqa.Tests;

import SeleniumTestingUsingPageObjectModel.demoqa.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utilities.Utilities.delay;

public class FormsTests extends BaseTest {
    @Test
    public void testScrollingToElement(){
        homePage.goToForms();
    }

    @Test
    public void testRadioButton(){
        var practiceForm = homePage.goToForms().clickPracticeForm();
        practiceForm.clickFemaleRadioButton();
        Assert.assertTrue(practiceForm.isFemaleSelected(), "Female Radio Button is not selected");
    }

    @Test
    public void testCheckBox(){
        var practiceForm = homePage.goToForms().clickPracticeForm();
        practiceForm.enableSportsHobbyCheckBox();
        practiceForm.enableReadingHobbyCheckBox();
        practiceForm.enableMusicHobbyCheckBox();
        practiceForm.disableReadingHobbyCheckBox();
        Assert.assertTrue(practiceForm.isSportsHobbySelected(), "Sports CheckBox is not enabled");
        Assert.assertTrue(practiceForm.isMusicHobbySelected(), "Music CheckBox is not enabled");
        Assert.assertFalse(practiceForm.isReadingHobbySelected(), "Reading CheckBox is enabled, it should be disabled");
    }
}
