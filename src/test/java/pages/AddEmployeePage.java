package pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {


    @FindBy(id = "firstName")
    public WebElement firstNameField;
    @FindBy(id = "middleName")
    public WebElement middleNameField;
    @FindBy(id = "lastName")
    public WebElement lastNameField;
    @FindBy(id = "employeeId")
    public WebElement empIDTextbox;
    @FindBy(id = "btnSave")
    public WebElement saveButton;
    @FindBy(id = "chkLogin")
    public WebElement createLoginCheckbox;
    @FindBy(id = "photofile")
    public WebElement photoUpload;
    @FindBy(id = "user_name")
    public WebElement userNameField;
    @FindBy(id = "user_password")
    public WebElement passwordField;
    @FindBy(id = "re_password")
    public WebElement reEnterPassField;
    @FindBy(id ="status")
    public WebElement statusDD;

    public void enterFirstAndLastName(String firstName, String lastName) {
        sendText(firstNameField, firstName);
        sendText(lastNameField, lastName);
    }

    public void enterFirstMiddleAndLastName(String firstName, String middleName, String lastName) {
        sendText(firstNameField, firstName);
        sendText(middleNameField, middleName);
        sendText(lastNameField, lastName);
    }

    public void enterEmployeeID(String employeeID) {
        sendText(empIDTextbox, employeeID);
    }


    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }
}