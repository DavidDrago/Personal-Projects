package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class SeleniumUtilities extends Utilities{
    private static Actions actions = new Actions(driver);

    private static Select findDropDown(By locator){
        return new Select(driver.findElement(locator));
    }

    public static void selectByVisibleText(By locator, String text){
        findDropDown(locator).selectByVisibleText(text);
    }

    public static void selectByValue(By locator, String value){
        findDropDown(locator).selectByValue(value);
    }

    public static void selectByIndex(By locator, int index){
        findDropDown(locator).selectByIndex(index);
    }

    public static void deselectByValue(By locator, String value){
        findDropDown(locator).deselectByValue(value);
    }

    public static List<String> getAllSelectedOptions(By locator){
        List<WebElement> allSelectedOptions = findDropDown(locator).getAllSelectedOptions();
        return allSelectedOptions.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public static Alert switchToAlert(){
        return driver.switchTo().alert();
    }

    public static void switchToFrame(int index){
        driver.switchTo().frame(index);
    }

    public static void switchToFrame(String nameOrId){
        driver.switchTo().frame(nameOrId);
    }

    public static void switchToFrame(WebElement frameElement){
        driver.switchTo().frame(frameElement);
    }

    public static void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public static void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public static String getWindowHandle(){
        return driver.getWindowHandle();
    }

    public static Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }

    public static void switchToWindow(String window){
        driver.switchTo().window(window);
    }

    public static void closeWindow(String tab){
        driver.switchTo().window(tab).close();
    }

    public static void explicitWaitUntilVisible(int seconds, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void fluentWaitUntilVisible(int seconds, By locator){
        FluentWait fluentWait = new FluentWait(driver).
                withTimeout(Duration.ofSeconds(seconds)).
                pollingEvery(Duration.ofMillis(500)).
                ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void dragAndDropBy(WebElement source, int x, int y){
        actions.dragAndDropBy(source, x, y).perform();
    }

    public static void doubleClick(WebElement target){
        actions.doubleClick(target).perform();
    }

    public static void contextClick(WebElement target){
        actions.contextClick(target).perform();
    }

    public static void sendKeys(WebElement target, String text){
        actions.sendKeys(target, Keys.chord(text)).perform();
    }

    public static void sendKeys(String text){
        actions.sendKeys(text).perform();
    }

    public static void tabSwitch(){
        actions.sendKeys(Keys.TAB).perform();
    }
}
