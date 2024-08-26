package com.ss.api.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\features", 
		glue = { "com.ss.api.stepdefinitions" }, 
		monochrome = true,
		plugin = { "pretty", "html:target/cucumber_reports.html" })

public class TestRunner {

}