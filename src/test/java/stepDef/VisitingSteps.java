package stepDef;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.homepage.HomePage;
import utils.helpers.PropertiesHandler;
import utils.webdriverprovider.DriverFactory;
import utils.webdriverprovider.SeleniumExecutor;

public class VisitingSteps {

    private HomePage homePage = new HomePage();
    
    @When("I go to home page")
    public void iGoToHomePage() throws InterruptedException {
        SeleniumExecutor.openPage(PropertiesHandler.getProperty("baseUri"));
        Thread.sleep(3000);
    }


    @Then("I can see some page")
    public void iCanSeeSomePage() {
        System.out.println(SeleniumExecutor.getUrl());
        Assert.assertTrue(SeleniumExecutor.getUrl().equals(PropertiesHandler.getProperty("baseUri")));
    }
}
