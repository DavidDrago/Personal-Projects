package PageObjectModel.demoqa.Widgets;

import org.openqa.selenium.By;

import static Utilities.SeleniumUtilities.fluentWaitUntilVisible;

public class ProgressBarPage extends WidgetsPage{
    private By startStopButton = By.id("startStopButton");
    private By progressBarPercent = By.xpath("//div[@id='progressBar']//div[@aria-valuenow='100']");

    public void clickStartButton(){
        click(startStopButton);
    }

    public String getProgressValue(){
        fluentWaitUntilVisible(30, progressBarPercent);
        return getText(progressBarPercent);
    }
}
