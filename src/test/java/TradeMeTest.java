import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import web.tradeMe.MainPage;
import web.tradeMe.ResultsPage;

import static org.junit.Assert.assertEquals;

public class TradeMeTest {

    public WebDriver driver;
    private MainPage mainPage;
    private ResultsPage resultsPage;

    @Rule
    public BrowserWebDriverContainer chrome =
            new BrowserWebDriverContainer()
                    .withCapabilities(new ChromeOptions().addArguments("--headless"));

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupBrowser() {
        driver = chrome.getWebDriver();
//        driver = new ChromeDriver();
        ChromeOptions remoteOptions = new ChromeOptions();

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
    }
}