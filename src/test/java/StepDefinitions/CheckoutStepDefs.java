package StepDefinitions;

import Pages.CheckoutPage;
import Pages.LoginPage;
import Scripts.Configuration;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CheckoutStepDefs {

    private final static Properties KEY_PROPERTIES = Configuration.KEY_PROPERTIES_FILE;
    @Then("^user fill the fields$")
    public void FillTheFields(DataTable dt) {
        List<Map<String, String>> rows = dt.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows){
            String field = columns.get("field");
            String userData = columns.get("user1");
            CheckoutPage.fieldsCamps(field, userData);
        }
    }

    @Then("^the user type firstname: '(.*)' lastname: '(.*)' and postal code: '(.*)'$")
    public void enterData(String firstname, String lastname, String postalcode){
        CheckoutPage.fillTheFields(firstname, lastname, postalcode);
    }
    @Then("the user click on continue button")
    public void clickContinue(){
        CheckoutPage.clickContinueButton();
    }

    @Then("the user click on finish button")
    public void clickFinish(){
        CheckoutPage.clickFinishButton();
    }

    @Then("^checkout message is displayed with the text '(.*)'$")
    public void controlMessageError(String errorMessageCheckout){
        String message = KEY_PROPERTIES.getProperty(errorMessageCheckout);
        Assert.assertTrue("The checkout is not correct", CheckoutPage.showMessageError(message));
    }
    @Then("^the user verifies that the product name of '(.*)' is correct$")
    public void verifyProductName(String product){
        Assert.assertTrue("Error: the text in the button is not the deserved", CheckoutPage.getTitleProduct(product));
    }
    @Then("^the user check if the names of the products are$")
    public void checkNamesOfTheProducts(DataTable dt){
        List<Map<String, String>> rows = dt.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows){
            String firstName = columns.get("names");
            System.out.println(firstName);
            Assert.assertTrue("Error:the products are not displayed", CheckoutPage.checkTheNames(firstName));
        }
    }

}