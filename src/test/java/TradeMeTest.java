import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import web.tradeMe.MainPage;
import web.tradeMe.ResultsPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TradeMeTest {

    public WebDriver driver;
    private MainPage mainPage;
    private ResultsPage resultsPage;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupBrowser() throws MalformedURLException {

        String sauceUserName = System.getenv("SAUCE_USERNAME");
        String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");

        /**
         * Here we set DesiredCapabilities, in this exercise we set additional capabilities below that align with
         * testing best practices such as timeouts, tags, and build numbers
         */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("username", sauceUserName);
        capabilities.setCapability("accessKey", sauceAccessKey);
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("version", "59.0");
//        capabilities.setCapability("name", method.getName());

        /** Tags are an excellent way to control and filter your test automation
         * in Sauce Analytics. Get a better view into your test automation.
         */
        List<String> tags = Arrays.asList("sauceDemo", "demoTest", "module4");
        capabilities.setCapability("tags", tags);

        /** Another of the most important things that you can do to get started
         * is to set timeout capabilities for Sauce based on your organizations needs. For example:
         * How long is the whole test allowed to run?*/
        capabilities.setCapability("maxDuration", 3600);
        /** A Selenium crash might cause a session to hang indefinitely.
         * Below is the max time allowed to wait for a Selenium command*/
        capabilities.setCapability("commandTimeout", 600);
        /** How long can the browser wait for a new command */
        capabilities.setCapability("idleTimeout", 1000);

        /** Setting a build name is one of the most fundamental pieces of running
         * successful test automation. Builds will gather all of your tests into a single
         * 'test suite' that you can analyze for results.
         * It's a best practice to always group your tests into builds. */
        capabilities.setCapability("build", "SauceDemo");

        /** Don't forget to enter in your application's URL in place of 'https://www.saucedemo.com'. */
        driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), capabilities);

        mainPage = new MainPage(driver);
    }

    @After
    public void teardownBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void printTotal() throws Exception {
        resultsPage = mainPage.searchFor("gold");
        String totalCount = resultsPage.getTotalResultCount();
        assertEquals("35", totalCount);

        ((JavascriptExecutor)driver).executeScript("sauce:job-result=passed");
    }
}