package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptUtilities extends Utilities{
    public static void scrollToElementJS(By locator){
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit wait
        // WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
