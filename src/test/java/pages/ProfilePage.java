package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ProfilePage extends CommonMethods {

    //This input field takes in first name
    @FindBy(xpath = "//input[@id = 'first_name']")
    public WebElement firstNameField;

    //This input field takes in first name
    @FindBy(xpath = "//input[@id = 'last_name']")
    public WebElement lastNameField;

    //This input field takes in a description any # of characters
    @FindBy(xpath = "//textarea[@id = 'description']")
    public WebElement descriptionField;

    //This is the button to save details
    @FindBy(xpath = "//button[text() ='Save profile details']")
    public WebElement continueButton;

    //This element shows that we have saved information successfully
    @FindBy(xpath = "//span[contains(text(), 'success')]")
    public WebElement successMessage;

    public static void clearAllFields() {
        profilePage.firstNameField.clear();
        profilePage.lastNameField.clear();
        profilePage.descriptionField.clear();
    }



    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public static void enterAllFields(String firstN, String lastN, String description) {
        profilePage.firstNameField.sendKeys(firstN);
        profilePage.lastNameField.sendKeys(lastN);
        profilePage.descriptionField.sendKeys(description);
    }

    public boolean allFieldsAreEmpty() {

        boolean allFieldsEmpty = false;

        if (profilePage.firstNameField.getText().isEmpty()) {
            if (profilePage.lastNameField.getText().isEmpty()) {
                if(profilePage.descriptionField.getText().isEmpty()) {
                    allFieldsEmpty = true;
                }
            }
        }
        return allFieldsEmpty;
    }
}
