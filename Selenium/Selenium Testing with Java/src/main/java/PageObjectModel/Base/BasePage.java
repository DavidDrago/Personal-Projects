package PageObjectModel.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static Utilities.JavaScriptUtilities.clickJS;
import org.openqa.selenium.WebElement;

public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected  void  set(By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator){
        try{
            find(locator).click();
        } catch (Exception e) {
            clickJS(locator);
        }
    }

    protected String getText(By locator){
        return find(locator).getText();
    }

    protected String getAttribute(By locator, String name){
        return find(locator).getAttribute(name);
    }

    protected Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    protected Boolean isSelected(By locator){
        return find(locator).isSelected();
    }
}
