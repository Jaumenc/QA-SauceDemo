package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Scripts.Commons;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class loginStepDefs {

    @Given("the user visit the sauce page")
    public void navigateToSauceDemoPage(){
        Commons.navigateTo("https://www.saucedemo.com");
    }

    @When("^the user type username: '(.*)' and password: '(.*)'$")
    public void enterUserPassw(String user, String password){
        LoginPage.enterUserPassw(user, password);
    }

    @When("the user click on login button")
    public void buttonClick(){
        LoginPage.onClickButton();
    }

    @Then("user is logged")
    public void isLogged(){
        HomePage.clickOnMenuButton();
        Assert.assertTrue("The user is not logged", HomePage.verifyLogOutButton());
    }
}
