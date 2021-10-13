package Runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/java/com/Features", glue = "com.stepDefinition", dryRun = false, plugin = {
		"pretty", "html:Reports/HTMLReport.html", "json:Reports/Jsonreport.json", "junit:Reports/JUnitreport.junit" })

public class TestRunner {

}