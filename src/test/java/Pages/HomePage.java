package Pages;

import Scripts.Commons;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class HomePage {
    private final static String BURGER_BUTTON = "//button[@id='react-burger-menu-btn']";
    private final static String LOGOUT_BUTTON = "//a[@id='logout_sidebar_link']";
    private final static String REMOVE_BUTTON_HOMEPAGE = "//button[@id='remove-sauce-labs-backpack']";
    private final static String CART_BUTTON = "//a[@class='shopping_cart_link']";
    private static String addCartGenericXpath = "//div[@class='inventory_item_label'][contains(.,'%s')]/following-sibling::div/button";
    private static String verifyPopUp = "//span[@class='shopping_cart_badge']";

    public static void clickOnMenuButton(){
        Commons.click(Commons.findElementByXpath(BURGER_BUTTON));
    }
    public static boolean verifyLogOutButton(){
        return Commons.findElementIsDisplayed(Commons.findElementByXpath(LOGOUT_BUTTON));
    }
    public static void clickOnRemoveButtonHomePage(){
        Commons.click(Commons.findElementByXpath(REMOVE_BUTTON_HOMEPAGE));
    }
    public static void clickOnCartButton(){
        Commons.click(Commons.findElementByXpath(CART_BUTTON));
    }
    public static void addProductToCart(String product){
        Commons.click(Commons.findElementByXpath(String.format(addCartGenericXpath,product)));
    }

    public static String getProductsPopUpCart(){
        return Commons.getText(Commons.findElementByXpath(verifyPopUp));
    }

    public static Boolean getTitleButtonRemove(String product){
        return Commons.getText(Commons.findElementByXpath(String.format(addCartGenericXpath, product))).matches("Remove");
    }

    public static boolean getColorButtonRemove(String product){
        WebElement buttonRemove = Commons.findElementByXpath(String.format(addCartGenericXpath, product));
        String colorRGBA = buttonRemove.getCssValue("color");
        String colorHEX = Color.fromString(colorRGBA).asHex();
        return colorHEX.equals("#e2231a");
    }
}
