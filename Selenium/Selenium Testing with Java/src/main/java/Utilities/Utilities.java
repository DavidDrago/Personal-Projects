package Utilities;

import PageObjectModel.Base.BasePage;
import org.openqa.selenium.WebDriver;

public class Utilities {
    public static WebDriver driver;

    public static void setUtilityDriver(){
        driver = BasePage.driver;
    }

    public  static void delay(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void println(String text){
        System.out.println(text);
    }
}
