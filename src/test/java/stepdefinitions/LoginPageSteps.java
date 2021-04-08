package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.LoginPage;
import testbase.PageInitializer;
import utils.CommonMethods;
import utils.ConfigsReader;

public class LoginPageSteps extends CommonMethods {

    @Given("I enter my correct login details")
    public void iEnterMyCorrectLoginDetails() {
        LoginPage.loginWithEmailAndPass(ConfigsReader.retrieveValue("email"), ConfigsReader.retrieveValue("password"));
    }

}
