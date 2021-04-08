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
                  glue = "com/hrms/stepdefinitions",
                dryRun = false, //dryRun true will give you snippets without fully running your test
                tags = "@login",//when true, will fail when there are unimplemented steps in scenario
                plugin = {"pretty", //pretty will print out steps in console.                         "rerun:target/FailedTests.txt", //tells you which scenarios failed
                            "json:target/cucumber.json",
                        "html:target/cucumber-default-reports", // generates default html report
                        "rerun:target/FailedTests.txt"//generate json report
                                                                    }
                                                                    )



public class TestRunner {
}
