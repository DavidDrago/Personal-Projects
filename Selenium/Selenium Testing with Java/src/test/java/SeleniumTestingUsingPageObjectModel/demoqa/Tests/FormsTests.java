package SeleniumTestingUsingPageObjectModel.demoqa.Tests;

import SeleniumTestingUsingPageObjectModel.demoqa.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        practiceForm.enableMusicCheckBox();
        Assert.assertTrue(practiceForm.isMusicEnabled(), "Music CheckBox is not enabled");
        practiceForm.enableSportsCheckBox();
        Assert.assertTrue(practiceForm.isSportsEnabled(), "Sports CheckBox is not enabled");
    }
}
