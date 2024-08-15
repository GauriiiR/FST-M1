package testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags  = "@activity4",
		/*
		 * plugin = {"json: test-reports/json-report.json"}, monochrome = true,
		 */
    plugin = {"html: test-reports"},
    monochrome = true
    
    /*plugin = {"pretty"},
    monochrome = true*/
)

public class ActivitiesRunnerActivity6 {

}
