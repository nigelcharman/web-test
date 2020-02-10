package web.tradeMe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("totalCount")));
    }

    public String getTotalResultCount()  {
        WebElement countNumber = driver.findElement(By.id("totalCount"));
        return countNumber.getText();
    }
}
