package StepDefinitions;

import Pages.RegistryGiftPage;
import Utilities.PropertiesReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistryGiftSteps {

    private final WebDriver webDriver = Hooks.webDriver;
    private final WebDriverWait webDriverWait;

    public RegistryGiftSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.webDriverWait = new WebDriverWait(webDriver, propertiesReader.getTimeout());
    }

    private RegistryGiftPage registryGiftPage;

    @Then("Registry and Gifting page should be displayed")
    public void registryAndGiftingPageShouldBeDisplayed() {

        registryGiftPage = new RegistryGiftPage(webDriver, webDriverWait);
        Assert.assertTrue(registryGiftPage.registryGiftPageIsDisplayed());
    }
    
    @When("Input registrant name with {string}")
    public void inputRegistrantNameWith(String name) {

        registryGiftPage = new RegistryGiftPage(webDriver, webDriverWait);
        registryGiftPage.inputRegistrantName(name);
    }

    @When("Select a registry or gift list type with {string}")
    public void selectARegistryOrGiftListTypeWith(String type) {

        registryGiftPage = new RegistryGiftPage(webDriver, webDriverWait);
        registryGiftPage.clickRegistryGiftTypeButton();
        registryGiftPage.clickRegistryGiftListType(type);
    }

    @When("Click search button")
    public void clickSearchButton() {

        registryGiftPage = new RegistryGiftPage(webDriver, webDriverWait);
        registryGiftPage.clickSearchButton();
    }
}
