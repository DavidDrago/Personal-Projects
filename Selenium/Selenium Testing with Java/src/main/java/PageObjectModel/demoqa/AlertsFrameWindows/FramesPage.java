package PageObjectModel.demoqa.AlertsFrameWindows;

import org.openqa.selenium.By;

import static Utilities.SeleniumUtilities.*;

public class FramesPage extends AlertsFrameWindowsPage{
    private String iFrameBigBox = "frame1";
    private By iFrameSmallBox = By.xpath("//div[@id='frame2Wrapper']/iframe");
    private By sampleHeading = By.id("sampleHeading");
    private By framesHeader = By.xpath("//div[@id='framesWrapper']//h1[text()='Frames']");

    public void switchToBigFrame(){
        switchToFrame(iFrameBigBox);
    }

    public void switchToSmallFrame(){
        //switchToFrame(1);
        switchToFrame(find(iFrameSmallBox));
    }

    public String getSampleHeading(){
        return getText(sampleHeading);
    }

    public String getFramesHeader(){
        return getText(framesHeader);
    }
}
