package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"html:target/cucumber-report",
						  "json:target/json.report"},
				 features="src/test/resources/features",
				 glue="step_definitions",
				 tags= {},//"@iframe, @alert",
				 dryRun=false)
public class CukesRunner {
	
}
