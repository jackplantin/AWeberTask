package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.rmi.runtime.Log;
import utils.CommonMethods;
import utils.ConfigsReader;

public class LoginPage extends CommonMethods {

    @FindBy(xpath = "//button[text() ='Continue']")
    public WebElement continueButton;

    //This button will login and navigate to WP dashboard
    @FindBy(xpath = "//button[text() = 'Log In']")
    public WebElement loginButton;

    //This field allows input of username or email
    @FindBy(xpath = "//input[@id='usernameOrEmail']")
    public WebElement userNameOrEmailField;

    //This field allows password input
    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordField;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public static void loginWithEmailAndPass(String email, String password) {
        loginPage.userNameOrEmailField.sendKeys(email);
        loginPage.continueButton.click();
        loginPage.passwordField.sendKeys(password);
        loginPage.loginButton.click();
    }
}
