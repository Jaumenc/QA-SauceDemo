package StepDefinitions;

import Pages.CartPage;
import Pages.HomePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class homepageStepDefs {

    @Then("the user click on the remove button from home page")
    public void RemoveClickHomePage(){
        HomePage.clickOnRemoveButtonHomePage();
    }

    @Then("the user click on the cart button")
    public void CartClick(){
        HomePage.clickOnCartButton();
    }

    @Then("^the user add the product '(.*)' to cart button$")
    public void AddProductToCart(String product){
       HomePage.addProductToCart(product);
    }
    @Then("^the user verifies that there are '(.*)' pop up products in the cart$")
    public void verifyPopUpCart(String quantity){
        //Assert.assertTrue("Error: the pop up don't have the correct value", HomePage.verifyPopUpCart(quantity));
        String actualValue = HomePage.getProductsPopUpCart();
        String expectedValue = quantity;
        Assert.assertTrue("Error: the pop up don't have the correct value. \n actual value: " +actualValue+ "\n Expected value: "+expectedValue, actualValue.equals(quantity));
    }

    @Then("^the user verifies if the button of '(.*)' have been changed to remove button$")
    public void verifyTitleRemoveButton(String product){
        Assert.assertTrue("Error: the text in the button is not the deserved", HomePage.getTitleButtonRemove(product));
    }

    @Then("^the user verifies if the button of '(.*)' have been changed the remove button color$")
    public void verifyColorButton(String product){
        Assert.assertTrue("Error: the color in the button is not the deserved", HomePage.getColorButtonRemove(product));
    }
}