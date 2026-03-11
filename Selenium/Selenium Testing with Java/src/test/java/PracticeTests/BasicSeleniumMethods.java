package PracticeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.Set;

import static Utilities.JavaScriptUtilities.scrollToElementJS;

public class BasicSeleniumMethods {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void testGetMethods() throws InterruptedException {
        String title = driver.getTitle(); // Gives the Title of the current page which is displayed on tab
        System.out.println(title);

        String url = driver.getCurrentUrl(); // Gives the URl of the current page
        System.out.println(url);

        String pageSource = driver.getPageSource(); // Gives us the whole source code of the current page
        // System.out.println(pageSource);

        String windowId = driver.getWindowHandle(); // Gives us a unique windowId of the current page
        System.out.println(windowId);

        By commentsAtom = By.xpath("//button[text()='New Tab']");
        WebElement element = driver.findElement(commentsAtom);
        String jsScript = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(jsScript, element);
        element.click();

        Set<String> windowIds = driver.getWindowHandles(); // Gives us unique windowsId's of all the open pages.
        for(var winId : windowIds){
            if(!Objects.equals(winId, windowId)){
                driver.switchTo().window(winId);
            }
        }
        System.out.println(driver.getWindowHandle());
        driver.switchTo().window(windowId);
        System.out.println(driver.getWindowHandle());
    }

    @Test
    public void testConditionalMethods(){
        WebElement element = driver.findElement(By.xpath("//label[text()='Male']"));
        boolean displayed = element.isDisplayed(); // check if the element is displayed
        System.out.println(displayed);

        element = driver.findElement(By.xpath("//input[@id='male']"));
        element.click();
        boolean selected = element.isSelected();
        System.out.println(selected);

        boolean enabled = element.isEnabled();
        System.out.println(enabled);
    }

    @Test
    public void testNavigationCommands(){
        driver.navigate().to("https://www.youtube.com/"); // To navigate to new URL page
        driver.navigate().back(); // To go back to previous page
        driver.navigate().forward(); // To go forward into new page
        driver.navigate().refresh(); // To refresh the current page
    }

    @AfterClass
    public void tearDown(){
        // driver.close(); // current window is closed.
        driver.quit(); // All windows are closed.
    }
}
