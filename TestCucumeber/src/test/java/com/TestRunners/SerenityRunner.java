package com.TestRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = {"C:\\Users\\villu\\eclipse-workspace\\TestCucumeber\\src\\test\\resources\\Parallel\\Login.feature"},
		glue = {"Parallel"},
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				})
public class SerenityRunner {

}
