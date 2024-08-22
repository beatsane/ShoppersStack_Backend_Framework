package com.ss.api.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "", 
		glue = { "" }, 
		plugin = { "pretty", "html:target/cucumber_reports.html" })

public class TestRunner extends AbstractTestNGCucumberTests {

}
