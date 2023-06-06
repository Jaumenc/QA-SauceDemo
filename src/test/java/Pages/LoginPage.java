package Pages;

import Scripts.Commons;

public class LoginPage {
    private final static String USER_NAME_INPUT = "//input[@id='user-name']";
    private final static String USER_PASSW_INPUT = "//input[@id='password']";
    private final static String LOGIN_BUTTON = "//input[@id='login-button']";
    public static void enterUserPassw(String user, String passw){
        Commons.setText(Commons.findElementByXpath(USER_NAME_INPUT),user);
        Commons.setText(Commons.findElementByXpath(USER_PASSW_INPUT),passw);
    }

    public static void onClickButton(){
        Commons.click(Commons.findElementByXpath(LOGIN_BUTTON));
    }
}
