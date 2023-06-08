package Scripts;

import Pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Commons extends BasePage {
    public Commons(WebDriver driver) {
        super(driver);
    }
    public static void navigateTo(String url){
        driver.get(url);
    }

    //Find methods
    public static WebElement findElementByXpath(String locator){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        }catch (Exception e){
            Assert.fail("Fail to find element: "+ locator);
            return null;
        }
    }

    public static void setText(WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
        }catch (Exception e){
            Assert.fail("Fail to set text on element: "+ element);
        }
    }

    public static void click(WebElement element){
        try {
            element.click();
        }catch (Exception e){
            Assert.fail("Fail to click on element: "+ element);
        }
    }

    public static boolean findElementIsDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        }catch (Exception ignored){
            return false;
        }
    }

    public static String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            Assert.fail("Fail to get text on element " +element);
            return null;
        }
    }

    // PROPERTIES METHODS
    public static Properties getProperties(String propertiesFileName){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(propertiesFileName)));
        } catch (FileNotFoundException e){
            Assert.fail("File not found: " +propertiesFileName);
            throw new RuntimeException(e);
        } catch (IOException e) {
            Assert.fail("Exception while is reading");
            throw new RuntimeException(e);
        }
        return properties;
    }
}