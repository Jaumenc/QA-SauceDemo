package Pages;

import Scripts.Commons;

public class HomePage {
    private final static String BURGER_BUTTON = "//button[@id='react-burger-menu-btn']";
    private final static String LOGOUT_BUTTON = "//a[@id='logout_sidebar_link']";
    public static void clickOnMenuButton(){
        Commons.click(Commons.findElementByXpath(BURGER_BUTTON));
    }
    public static boolean verifyLogOutButton(){
        return Commons.findElementIsDisplayed(
                Commons.findElementByXpath(LOGOUT_BUTTON)
        );
    }
}
