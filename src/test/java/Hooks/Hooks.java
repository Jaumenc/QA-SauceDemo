package Hooks;

import Pages.BasePage;
import Utils.BrowserUtils;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static Pages.BasePage.driver;

public class Hooks {
    public static String windowSize = System.getProperty("windowSize");
    @Before
    public void setUp (){
        BasePage.setUp();
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
    @After
    public void afterScenario(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
    @AfterAll
    public static void tearDown(){
        BasePage.closeBrowser();
    }
}
