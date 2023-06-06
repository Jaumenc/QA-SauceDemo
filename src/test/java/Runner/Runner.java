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
        stepNotifications = true,
        tags = "@sauceDemo"
)
public class Runner {
    @AfterClass
    public static void tearDown(){
        BasePage.closeBrowser();
    }
}