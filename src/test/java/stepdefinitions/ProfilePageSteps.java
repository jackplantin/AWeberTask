package stepdefinitions;


import io.cucumber.java.en.And;


import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ProfilePage;
import utils.CommonMethods;


public class ProfilePageSteps extends CommonMethods {


    @And("I enter in details for all fields of Profile Section first name {string}, last name {string}, description {string}")
    public void iEnterInDetailsForAllFieldsOfProfileSection(String firstN, String lastN, String description) {
        waitForClickability(profilePage.firstNameField);
        waitForClickability(profilePage.lastNameField);
        waitForVisibility("//textarea[@id = 'description']");
        ProfilePage.enterAllFields(firstN, lastN, description);
    }

    @And("Click save details button")
    public void clickSaveDetailsButton() {
        profilePage.saveProfileDetailsButton.click();
    }

    @Then("I should verify success message is displayed")
    public void iShouldVerifySuccessMessageIsDisplayed() {
        waitForVisibility("//span[contains(text(), 'success')]");
        Assert.assertTrue(profilePage.successMessage.isDisplayed());
    }
}
