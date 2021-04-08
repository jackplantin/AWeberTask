package runners;


//4 types of runners
//Test Runner
//Regression Runner
//Failed Runner (collects all failed tests)


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "stepdefinitions",
        dryRun = false,
        tags = "@profile",
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-default-reports.html",
        }
)


public class TestRunner {
}
