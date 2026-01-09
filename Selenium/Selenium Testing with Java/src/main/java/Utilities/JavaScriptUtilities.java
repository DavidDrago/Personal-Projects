package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtilities extends Utilities{
    public static void scrollToElement(By locator){
        WebElement webElement = driver.findElement(locator);
        String jsScript = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(jsScript, webElement);
    }

    public static void clickJS(By locator){
        WebElement webElement = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor)driver; // alternate ways of doing
        executor.executeScript("arguments[0].click();", webElement);
    }
}
