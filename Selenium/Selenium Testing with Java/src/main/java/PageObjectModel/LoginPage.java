package PageObjectModel;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-btn");
    private By errorMessage = By.cssSelector("#login-alert div");

    public void setUsername(String username){
        set(usernameField, username);
    }

    public  void setPassword(String password){
        set(passwordField, password);
    }

    public BankPage clickLogin(){
        click(loginButton);
        return new BankPage();
    }

    public  BankPage LoginIntoApplication(String username, String password){
        set(usernameField, username);
        set(passwordField, password);
        return clickLogin();
    }

    public String getErrorMessage(){
        return find(errorMessage).getText();
    }
}
