import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class TradeMeTest {

    public WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.get("https://www.tmsandbox.co.nz/");
    }

    @After
    public void teardownBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void printTotal() throws Exception {
        WebElement searchBar = driver.findElement(By.id("searchString"));
        searchBar.sendKeys("gold");
        searchBar.sendKeys(Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("totalCount")));
        WebElement countNumber = driver.findElement(By.id("totalCount"));
        String totalCount = countNumber.getText();
        assertEquals("35", totalCount);
    }
}