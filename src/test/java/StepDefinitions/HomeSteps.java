package StepDefinitions;

import Pages.HomePage;
import Utilities.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeSteps {

    private final WebDriver webDriver = Hooks.webDriver;
    private final WebDriverWait webDriverWait;

    public HomeSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.webDriverWait = new WebDriverWait(webDriver, propertiesReader.getTimeout());
    }

    private HomePage homePage;

    @Given("Home page of Amazon website")
    public void homePageOfAmazonWebsite() {

        homePage = new HomePage(webDriver, webDriverWait);
        Assert.assertTrue(homePage.headerIsDisplayed());
        Assert.assertTrue(homePage.homeIsDisplayed());

        int dontChangeButtonQuestion = homePage.dontChangeButtonQuestionSize();
        if (dontChangeButtonQuestion > 0) {
            homePage.clickDontChangeAddress();
        }
    }

    @When("Navigate to Registry tab")
    public void navigateToRegistryTab() {

        homePage = new HomePage(webDriver, webDriverWait);
        Assert.assertTrue(homePage.headerIsDisplayed());
        homePage.clickRegistryTab();
    }
}
