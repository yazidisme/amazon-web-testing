package StepDefinitions;

import Pages.BirthdayGiftListPage;
import Utilities.PropertiesReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Utilities.DataGenerator.*;

public class BirthdayGiftListSteps {

    private final WebDriver webDriver = Hooks.webDriver;
    private final WebDriverWait webDriverWait;

    public BirthdayGiftListSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.webDriverWait = new WebDriverWait(webDriver, propertiesReader.getTimeout());
    }

    private BirthdayGiftListPage birthdayGiftListPage;

    @Then("Search result with name is {string} should be displayed")
    public void searchResultWithNameIsShouldBeDisplayed(String name) {

        birthdayGiftListPage = new BirthdayGiftListPage(webDriver, webDriverWait);
        Assert.assertTrue(birthdayGiftListPage.birthdayGiftListSearchResultIsDisplayed());

        String nameLowerCase = name.toLowerCase();
        String actualSearchResultTitle = birthdayGiftListPage.getSearchResultTitle().toLowerCase();
        Assert.assertEquals(nameLowerCase, actualSearchResultTitle);

        int searchResultTotal = birthdayGiftListPage.getSearchResultList();
        for (int index = 0; index < searchResultTotal; index++) {

            String actualParentGuardianNameList = birthdayGiftListPage.getParentGuardianNameResult(index).toLowerCase();
            Assert.assertTrue(actualParentGuardianNameList.contains(nameLowerCase));
        }
    }

    @When("Edit date range from {string} to {string}")
    public void editDateRangeFromTo(String fromDate, String toDate) throws InterruptedException {

        birthdayGiftListPage = new BirthdayGiftListPage(webDriver, webDriverWait);

        String regex = " ";

        String[] fromDateSplit = fromDate.split(regex);
        String fromMonth = fromDateSplit[0];
        String fromYear = fromDateSplit[1];

        String[] toDateSplit = toDate.split(regex);
        String toMonth = toDateSplit[0];
        String toYear = toDateSplit[1];

        birthdayGiftListPage.clickMonthFromButton();
        birthdayGiftListPage.clickMonthYearValue(fromMonth);

        birthdayGiftListPage.clickYearFromButton();
        birthdayGiftListPage.clickMonthYearValue(fromYear);

        birthdayGiftListPage.clickMonthToButton();
        birthdayGiftListPage.clickMonthYearValue(toMonth);

        birthdayGiftListPage.clickYearToButton();
        birthdayGiftListPage.clickMonthYearValue(toYear);

        birthdayGiftListPage.clickSearchBirthdayGiftButton();
        Thread.sleep(2000);
    }

    @Then("The search result is in accordance with the date range from {string} to {string}")
    public void theSearchResultIsInAccordanceWithTheDateRangeFromTo(String fromDate, String toDate) throws ParseException {

        birthdayGiftListPage = new BirthdayGiftListPage(webDriver, webDriverWait);
        Assert.assertTrue(birthdayGiftListPage.birthdayGiftListSearchResultIsDisplayed());

        String actualPattern = "MMM dd,yyyy";
        String pattern = "MMMMM yyyy";
        SimpleDateFormat simpleDateFormat;

        int searchResultTotal = birthdayGiftListPage.getSearchResultList();
        for (int index = 0; index < searchResultTotal; index++) {

            simpleDateFormat = new SimpleDateFormat(actualPattern);
            String actualDateList = birthdayGiftListPage.getDateResult(index);
            Date actualDateFormat = simpleDateFormat.parse(actualDateList);

            simpleDateFormat = new SimpleDateFormat(pattern);
            Date fromDateFormat = simpleDateFormat.parse(fromDate);

            Date toDateFormat = simpleDateFormat.parse(toDate);
            Date toDateLastDay = getLastDateTimeOfMonth(toDateFormat);

            Assert.assertTrue(actualDateFormat.after(fromDateFormat));
            Assert.assertTrue(actualDateFormat.before(toDateLastDay));
        }
    }
}
