package PageObjectModel.demoqa.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static Utilities.JavaScriptUtilities.scrollToElementJS;
import static Utilities.SeleniumUtilities.sendKeys;

public class TextBoxPage extends ElementsPage{
    private By userNameField = By.id("userName");
    private By submit = By.id("submit");
    private By emailOutput = By.id("email");

    public void setUserName(String name){
        scrollToElementJS(userNameField);
        sendKeys(find(userNameField), Keys.chord(name));
    }

    public void setEmail(String email){
        sendKeys(Keys.chord(Keys.TAB, email));
    }

    public void setCurrentAddress(String address){
        sendKeys(address + Keys.ENTER);
    }

    public void clickSubmit(){
        scrollToElementJS(submit);
        click(submit);
    }

    public String getEmailOutput(){
        return getText(emailOutput);
    }
}
