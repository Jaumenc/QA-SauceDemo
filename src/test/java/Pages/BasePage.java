package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static WebDriver driver;
    protected static WebDriverWait wait;
    private static final String WEB_DRIVER = System.getProperty("webDriver");

    private static final String CHROME_DRIVER = "chrome";
    private static final String FIREFOX_DRIVER = "firefox";
    private static boolean headlessMode = Boolean.parseBoolean(System.getProperty("headlessMode"));

    public static void setUp() {
        switch (WEB_DRIVER){
            case CHROME_DRIVER :
                System.out.println("chrome driver selected");
                chromeDriver();
                break;
            case FIREFOX_DRIVER:
                System.out.println("firefox driver selected");
                firefoxDriver();
                break;
        }
    }

    public static void chromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if(headlessMode){
            options.addArguments("--headless");
            System.out.println("HeadlessMode selected");
        }
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void firefoxDriver(){
        FirefoxOptions options = new FirefoxOptions();
        if(headlessMode){
            options.addArguments("--headless");
            System.out.println("HeadlessMode selected");
        }
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public static void closeBrowser(){
        driver.quit();
    }
}