package Pages;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BirthdayGiftListPage extends BaseClass {

    public BirthdayGiftListPage(WebDriver webDriver, WebDriverWait webDriverWait) {

        super(webDriver, webDriverWait);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//a[@aria-label='Birthday Gift List']")
    private WebElement birthdayGiftListLogo;

    @FindBy(xpath = "//div[@class='gr-search-title-lable']")
    @CacheLookup
    private WebElement findBirthdayGiftTitle;

    @FindBy(id = "wr-search-name-or-email")
    private WebElement parentGuardianNameInput;

    @FindBy(id = "a-autoid-1-announce")
    @CacheLookup
    private WebElement monthFromButton;

    @FindBy(id = "a-autoid-2-announce")
    @CacheLookup
    private WebElement yearFromButton;

    @FindBy(id = "a-autoid-3-announce")
    @CacheLookup
    private WebElement monthToButton;

    @FindBy(id = "a-autoid-4-announce")
    @CacheLookup
    private WebElement yearToButton;

    @FindBy(id = "a-autoid-5")
    @CacheLookup
    private WebElement searchBirthdayGiftButton;

    @FindBy(xpath = "//span[@class='current-search-name-slot']")
    private WebElement searchResultTitle;

    @FindBy(xpath = "//a[contains(@href,'search_page_result')]//parent::div//parent::li[contains(@class,'gr-search-registry')]")
    private List<WebElement> searchResultList;

    @FindBy(xpath = "//div[@class='gr-search-registry-name']//a[not(contains(@href,'void(0)'))]")
    private List<WebElement> parentGuardianNameResult;

    @FindBy(xpath = "//div[@class='gr-search-registry-date' and contains(text(),' ')]")
    private List<WebElement> dateResult;

    public boolean birthdayGiftListSearchResultIsDisplayed() {

        waitUntilElementIsVisible(birthdayGiftListLogo);
        waitUntilElementIsVisible(findBirthdayGiftTitle);
        waitUntilElementIsVisible(parentGuardianNameInput);
        waitUntilElementIsVisible(monthFromButton);
        waitUntilElementIsVisible(yearFromButton);
        waitUntilElementIsVisible(monthToButton);
        waitUntilElementIsVisible(yearToButton);
        waitUntilElementIsVisible(searchBirthdayGiftButton);
        waitUntilElementIsVisible(searchResultTitle);
        waitUntilListElementIsVisible(searchResultList);
        waitUntilListElementIsVisible(parentGuardianNameResult);
        waitUntilListElementIsVisible(dateResult);
        return true;
    }

    public String getSearchResultTitle() {

        return searchResultTitle.getText();
    }

    public int getSearchResultList() {

        return searchResultList.size();
    }

    public String getParentGuardianNameResult(int index) {

        return parentGuardianNameResult.get(index).getText();
    }

    public String getDateResult(int index) {

        return dateResult.get(index).getText();
    }

    public void clickMonthFromButton() {

        waitUntilElementIsClickable(monthFromButton);
        monthFromButton.click();
    }

    public void clickYearFromButton() {

        waitUntilElementIsClickable(yearFromButton);
        yearFromButton.click();
    }

    public void clickMonthToButton() {

        waitUntilElementIsClickable(monthToButton);
        monthToButton.click();
    }

    public void clickYearToButton() {

        waitUntilElementIsClickable(yearToButton);
        yearToButton.click();
    }

    public void clickMonthYearValue(String monthOrYear) {

        String xpath = "//div[@aria-hidden='false']//a[text()='"+ monthOrYear + "']";
        WebElement monthYearValue = webDriver.findElement(By.xpath(xpath));
        waitUntilElementIsVisible(monthYearValue);
        waitUntilElementIsClickable(monthYearValue);
        monthYearValue.click();
    }

    public void clickSearchBirthdayGiftButton() {

        waitUntilElementIsClickable(searchBirthdayGiftButton);
        searchBirthdayGiftButton.click();
    }
}
