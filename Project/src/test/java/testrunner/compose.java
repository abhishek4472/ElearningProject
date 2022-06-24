package testrunner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="src/test/java/feature",
		glue={"stepdefinition","hooks"},
		monochrome = true,
		dryRun=false,
		tags={""},
		plugin={"pretty","html:Reports","json:Reports/jsonreport.json","junit:Reports/xmlreport.xml"}
		
		)

public class compose {

}
