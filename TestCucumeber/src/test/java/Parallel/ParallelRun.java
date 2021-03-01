package Parallel;


import org.testng.annotations.DataProvider;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = {"C:\\Users\\villu\\eclipse-workspace\\TestCucumeber\\src\\test\\resources\\Parallel\\Login.feature"},
		glue = {"Parallel"},
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/","rerun:target/failedrun.txt"})
		
public class ParallelRun extends AbstractTestNGCucumberTests{
	
	   @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }

}
