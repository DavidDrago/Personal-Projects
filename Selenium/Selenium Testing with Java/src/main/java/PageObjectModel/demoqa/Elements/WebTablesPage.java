package PageObjectModel.demoqa.Elements;

import org.openqa.selenium.By;

public class WebTablesPage extends ElementsPage {

    private By registrationFirstNameField = By.id("firstName");
    private By registrationLastNameField = By.id("lastName");
    private By registrationEmailField = By.id("userEmail");
    private By registrationAgeField = By.id("age");
    private By registrationSalaryField = By.id("salary");
    private By registrationDepartmentField = By.id("department");
    private By registrationSubmitButton = By.id("submit");
    private By addNewRecordButton = By.id("addNewRecordButton");

    public void clickEdit(String email){
        By tableEdit = By.xpath("//div[text()='"+ email +"']//following::span[@title='Edit']");
        click(tableEdit);
    }

    public void clickSubmitButton(){
        click(registrationSubmitButton);
    }

    public void clickAddButton(){
        click(addNewRecordButton);
    }

    public void setFirstName(String firstName){
        set(registrationFirstNameField, firstName);
    }

    public void setLastName(String lastName){
        set(registrationLastNameField, lastName);
    }

    public void setEmail(String email){
        set(registrationEmailField, email);
    }

    public void setAge(String age){
        set(registrationAgeField, age);
    }

    public void setSalary(String salary){
        set(registrationSalaryField, salary);
    }

    public void setDepartment(String department){
        set(registrationDepartmentField, department);
    }

    public String getTableAge(String email){
        By tableAge = By.xpath("//div[text()='"+ email +"']//preceding::div[1]");
        return find(tableAge).getText();
    }

    public boolean isFirstNameDisplayed(String firstName){
        By tableFirstName = By.xpath("//div[text()='"+ firstName +"']");
        return find(tableFirstName).isDisplayed();
    }

    public boolean isLastNameDisplayed(String lastName){
        By tableLastName = By.xpath("//div[text()='"+ lastName +"']");
        return find(tableLastName).isDisplayed();
    }

    public boolean isEmailDisplayed(String email){
        By tableEmail = By.xpath("//div[text()='"+ email +"']");
        return find(tableEmail).isDisplayed();
    }
}
