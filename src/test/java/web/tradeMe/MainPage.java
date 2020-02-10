package web.tradeMe;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.tmsandbox.co.nz/");
    }

    public ResultsPage searchFor(String searchText) {
        WebElement searchBar = driver.findElement(By.id("searchString"));
        searchBar.sendKeys(searchText);
        searchBar.sendKeys(Keys.RETURN);
        return new ResultsPage(driver);
    }
}
