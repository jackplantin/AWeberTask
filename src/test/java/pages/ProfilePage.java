package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ProfilePage extends CommonMethods {

    @FindBy(xpath = "//img[@class='gravatar']")
    public WebElement myProfileIconButton;

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

}
