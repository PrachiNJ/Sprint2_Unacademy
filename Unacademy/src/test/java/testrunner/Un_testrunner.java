package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"featurefiles/un_startlearning.feature"} /// which feature files to run
		,glue={"stepDefinitions"}				//package names having the scripts for the feature file
		,tags= "@tag1"			// the tags to run.... which are in feature file		
		)

public class Un_testrunner extends AbstractTestNGCucumberTests {

}
