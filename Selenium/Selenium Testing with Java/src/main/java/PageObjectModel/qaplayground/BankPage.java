package PageObjectModel.qaplayground;

import PageObjectModel.Base.BasePage;
import org.openqa.selenium.By;

public class BankPage extends BasePage {
    private By bankNameField = By.xpath("//span[text()='SecureBank']");

    public boolean isBankNameDisplayed(){
        return find(bankNameField).isDisplayed();
    }
}
