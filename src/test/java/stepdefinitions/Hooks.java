package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testbase.BaseClass;
import utils.CommonMethods;

public class Hooks {
    //annotation based functions via cucumber
    //hooks are implemented for all different features across project
    //they are based on annotations @Before and @After

    //Background is implemented for the specific feature

    @Before //these run because we use stepdefinitions as glue and hooks is in glue
    public void startTest() {
        BaseClass.setUp();
    }

    @After
    public void endTest(Scenario scenario) {
       byte[] screenshot;
        if (scenario.isFailed()) {
          screenshot =  CommonMethods.takeScreenshot("/failed/" + scenario.getName());
        } else {
            screenshot = CommonMethods.takeScreenshot("/passed/" + scenario.getName());
        }

        scenario.attach(screenshot, "image/png", scenario.getName());

//       BaseClass.tearDown();
    }
}
