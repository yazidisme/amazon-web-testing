package Pages;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistryGiftPage extends BaseClass {

    public RegistryGiftPage(WebDriver webDriver, WebDriverWait webDriverWait) {

        super(webDriver, webDriverWait);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Registry & Gifting')]")
    private WebElement registryGiftPageTitle;

    @FindBy(xpath = "//div[contains(@class,'gr-find-stripe__header')]")
    private WebElement searchRegistryGiftTitle;

    @FindBy(xpath = "//input[contains(@name,'name')]")
    private WebElement registrantNameInput;

    @FindBy(id = "a-autoid-0-announce")
    private WebElement selectRegistryGiftTypeButton;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    private WebElement searchButton;

    public boolean registryGiftPageIsDisplayed() {

        waitUntilElementIsVisible(registryGiftPageTitle);
        waitUntilElementIsVisible(searchRegistryGiftTitle);
        waitUntilElementIsVisible(registrantNameInput);
        waitUntilElementIsVisible(selectRegistryGiftTypeButton);
        waitUntilElementIsVisible(searchButton);
        return true;
    }

    public void inputRegistrantName(String name) {

        waitUntilElementIsClickable(registrantNameInput);
        registrantNameInput.sendKeys(name);
    }

    public void clickRegistryGiftTypeButton() {

        waitUntilElementIsClickable(selectRegistryGiftTypeButton);
        selectRegistryGiftTypeButton.click();
    }

    public void clickRegistryGiftListType(String listType) {

        String xpath = "//li[contains(@class,'dropdown-item')]//a[contains(text(),'" + listType + "')]";
        WebElement listTypeItem = webDriver.findElement(By.xpath(xpath));
        waitUntilElementIsVisible(listTypeItem);
        waitUntilElementIsClickable(listTypeItem);
        listTypeItem.click();
    }

    public void clickSearchButton() {

        waitUntilElementIsClickable(searchButton);
        searchButton.click();
    }
}
