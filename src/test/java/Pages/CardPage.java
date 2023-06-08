package Pages;

import Scripts.Commons;

public class CardPage {
    private final static String REMOVE_BUTTON_CARDPAGE = "//button[@id='remove-sauce-labs-backpack']";

    public static void clickOnRemoveButtonCardPage() {
        Commons.click(Commons.findElementByXpath(REMOVE_BUTTON_CARDPAGE));
    }
}