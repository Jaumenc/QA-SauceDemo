package Runner;

import Pages.BasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {
                "StepDefinitions",
                "Hooks"
        },
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        stepNotifications = true,
        tags = "@sauceDemo1"
)
public class Runner {
    @AfterClass
    public static void tearDown(){
      //  BasePage.closeBrowser();
    }
}