package Pages;

import Scripts.Commons;

public class HomePage {
    private final static String BURGER_BUTTON = "//button[@id='react-burger-menu-btn']";
    private final static String LOGOUT_BUTTON = "//a[@id='logout_sidebar_link']";
    private final static String ADD_TO_CARD_BUTTON = "//button[@id='add-to-cart-sauce-labs-backpack']";
    private final static String REMOVE_BUTTON_HOMEPAGE = "//button[@id='remove-sauce-labs-backpack']";
    private final static String CARD_BUTTON = "//span[@class='shopping_cart_badge']";
    public static void clickOnMenuButton(){
        Commons.click(Commons.findElementByXpath(BURGER_BUTTON));
    }
    public static boolean verifyLogOutButton(){
        return Commons.findElementIsDisplayed(
                Commons.findElementByXpath(LOGOUT_BUTTON)
        );
    }
    public static void clickOnAddToCardButton(){
        Commons.click(Commons.findElementByXpath(ADD_TO_CARD_BUTTON));
    }
    public static void clickOnRemoveButtonHomePage(){
        Commons.click(Commons.findElementByXpath(REMOVE_BUTTON_HOMEPAGE));
    }
    public static void clickOnCardButton(){
        Commons.click(Commons.findElementByXpath(CARD_BUTTON));
    }
}
