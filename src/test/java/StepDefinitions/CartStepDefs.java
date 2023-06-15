package StepDefinitions;

import Pages.CartPage;
import io.cucumber.java.en.Then;

public class CartStepDefs {
    @Then("the user click on the remove button from card page")
    public void RemoveClickCartPage(){
        CartPage.clickOnRemoveButtonCartPage();
    }

    @Then("the user click on the checkout button")
    public void CheckoutClickCartPage(){
        CartPage.clickOnCheckoutCartPage();
    }
}
