package Hooks;

import Utils.BrowserUtils;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static Pages.BasePage.driver;

public class Hooks {
    public static String windowSize = System.getProperty("windowSize");
    @Before
    public void setUp (){
        if(windowSize!=null){
            System.out.println("Window size:" +windowSize);
            BrowserUtils.setWindowSize(driver, windowSize);
        } else {
            BrowserUtils.maxWindowSize(driver);
        }
    }
    @AfterStep
    public void addScreenShot(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "screenshot");
            System.out.println("The screenshot is done");
        }
    }
}
