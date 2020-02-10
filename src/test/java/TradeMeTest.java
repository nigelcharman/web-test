import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import web.tradeMe.MainPage;
import web.tradeMe.ResultsPage;

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
    public void setupBrowser() {
        driver = new ChromeDriver();
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
        assertEquals("59", totalCount);
    }
}