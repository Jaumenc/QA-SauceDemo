package Pages;

import Scripts.Commons;

public class CartPage {
    private final static String REMOVE_BUTTON_CARDPAGE = "//button[@id='remove-sauce-labs-backpack']";
    private final static String CHECKOUT_BUTTON_CARDPAGE = "//button[@id='checkout']";

    public static void clickOnRemoveButtonCartPage() {
        Commons.click(Commons.findElementByXpath(REMOVE_BUTTON_CARDPAGE));
    }

    public static void clickOnCheckoutCartPage(){
        Commons.click(Commons.findElementByXpath(CHECKOUT_BUTTON_CARDPAGE));
    }
}