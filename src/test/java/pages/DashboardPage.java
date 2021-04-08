package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;
import utils.CommonMethods;

public class DashboardPage extends CommonMethods {
    @FindBy(xpath = "//a[contains(@title, 'profile')]")
    public WebElement myProfileIconButton;

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }
}
