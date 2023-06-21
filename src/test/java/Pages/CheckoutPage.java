package Pages;

import Scripts.Commons;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage {
    private static final String FIRST_NAME_FIELD = "//input[@id='first-name']";
    private static final String LAST_NAME_FIELD = "//input[@id='last-name']";
    private static final String POSTAL_CODE_FIELD = "//input[@id='postal-code']";
    private static final String GENERIC_XPATH_DATA = "//input[@id='%s']";
    private static final String CONTINUE_BUTTON = "//input[@id='continue']";
    private static final String FINISH_BUTTON = "//button[@id='finish']";
    private static final String MESSAGE_ERROR = "//h3[@data-test='error']";
    private static final String PRODUCT_NAME = "//div[@class='inventory_item_name']";
    private static final String GENERIC_XPATH_PRODUCTS = "//div[@class='inventory_item_name']";

    public static void fillTheFields(String firstname, String lastname, String postalcode){
        Commons.setText(Commons.findElementByXpath(FIRST_NAME_FIELD), firstname);
        Commons.setText(Commons.findElementByXpath(LAST_NAME_FIELD), lastname);
        Commons.setText(Commons.findElementByXpath(POSTAL_CODE_FIELD), postalcode);
    }

    public static void clickContinueButton(){
        Commons.click(Commons.findElementByXpath(CONTINUE_BUTTON));
    }

    public static void clickFinishButton(){
        Commons.click(Commons.findElementByXpath(FINISH_BUTTON));
    }

    public static void fieldsCamps(String id, String value){
        Commons.setText(Commons.findElementByXpath(String.format(GENERIC_XPATH_DATA, id)), value);
    }

    public static boolean showMessageError(String errorMessageCheckout){
        return Commons.getText(Commons.findElementByXpath(MESSAGE_ERROR)).matches(errorMessageCheckout);
    }

    public static boolean getTitleProduct(String product){
        return Commons.getText(Commons.findElementByXpath(PRODUCT_NAME)).matches(product);
    }

    public static boolean checkTheNames(String product){
//return Commons.findElementIsDisplayed(Commons.findElementByXpath(String.format(GENERIC_XPATH_PRODUCTS, product)));
        List<WebElement> lista = Commons.findElementsByXpath(GENERIC_XPATH_PRODUCTS);
        for(WebElement nameProducts : lista){
            String name = nameProducts.getText();
            if(name.matches(product)){
                return true;
            }
        }
        return false;
    }
}
