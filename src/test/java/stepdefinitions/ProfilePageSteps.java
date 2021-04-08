package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.ProfilePage;
import utils.CommonMethods;


public class ProfilePageSteps extends CommonMethods {


    @Given("I clear all fields of Profile Section")
    public void iClearAllFieldsOfProfileSection() {
        ProfilePage.clearAllFields();

    }


    @And("I enter in details for all fields of Profile Section first name {string}, last name {string}, description {string}")
    public void iEnterInDetailsForAllFieldsOfProfileSection(String firstN, String lastN, String description) {

            if (profilePage.allFieldsAreEmpty()) {
                ProfilePage.enterAllFields(firstN, lastN, description);
            }

    }
}
