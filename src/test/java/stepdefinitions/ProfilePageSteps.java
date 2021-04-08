package stepdefinitions;

import io.cucumber.java.en.Given;
import testbase.PageInitializer;

public class ProfilePageSteps extends PageInitializer {

    @Given("I navigate to the Profile Section of WordPress")
    public void i_navigate_to_the_profile_section_of_word_press() {
        profilePage.myProfileIconButton.click();
    }

}
