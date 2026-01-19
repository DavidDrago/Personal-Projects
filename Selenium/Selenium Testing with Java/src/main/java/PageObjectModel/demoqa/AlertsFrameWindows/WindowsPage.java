package PageObjectModel.demoqa.AlertsFrameWindows;

import org.openqa.selenium.By;

import java.util.Set;

import static Utilities.SeleniumUtilities.*;

public class WindowsPage extends AlertsFrameWindowsPage{
    private By newTabButton = By.id("tabButton");
    private By newWindowButton = By.id("windowButton");
    private By simpleHeading = By.id("sampleHeading");
    private By windowsHeader = By.xpath("//div[@id='browserWindows']//h1");
    private String mainWindow = getWindowHandle();

    public void clickOnNewTab(){
        click(newTabButton);
    }

    public void clickOnNewWindow(){
        click(newWindowButton);
    }

    public void switchToNewTabOrWindow(){
        println("Main Tab: "+ mainWindow);
        Set<String> allTabs = getWindowHandles();
        println("No. of Tabs: " + allTabs.size());
        for(String tab : allTabs){
            if(!mainWindow.equals(tab)){
                switchToWindow(tab);
                println("New Tab: "+ tab);
            }
        }
    }

    public void closeCurrentWindow(){
        String currentTab = getWindowHandle();
        closeWindow(currentTab);
        switchToWindow(mainWindow);
    }

    public String getSimpleHeading(){
        return find(simpleHeading).getText();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public String getWindowsHeader(){
        return find(windowsHeader).getText();
    }
}
