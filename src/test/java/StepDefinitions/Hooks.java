package StepDefinitions;

import Utilities.PropertiesReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver webDriver;

    @Before
    public void setup() throws Exception {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--window-size=1440,768", "--disable-gpu");
        webDriver = new ChromeDriver(chromeOptions);
        PropertiesReader propertiesReader = new PropertiesReader();
        webDriver.manage().timeouts().implicitlyWait(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();
        webDriver.get(PropertiesReader.getValue("url"));
    }
    
    @After
    public void teardown(Scenario scenario) {
        
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
        webDriver.quit();
    }
}
