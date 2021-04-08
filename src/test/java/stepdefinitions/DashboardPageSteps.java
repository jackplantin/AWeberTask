package stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testbase.PageInitializer;
import utils.CommonMethods;

public class DashboardPageSteps extends CommonMethods {

    @Given("I navigate to the Profile Section of WordPress")
    public void i_navigate_to_the_profile_section_of_word_press() {
        waitForClickability(dashboardPage.myProfileIconButton);
        jsClick(dashboardPage.myProfileIconButton);
    }
}
