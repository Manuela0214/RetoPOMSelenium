package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;

public class Base {

    protected WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public void visitPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void clearText(By locator) {
        driver.findElement(locator).clear();
    }

    public void typeText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator) {
        try{
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void implicitWait(int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public void waitUntilElementClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Alert waitForAlert(int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void scrollToElement(By locator){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        action.moveToElement(element).perform();
    }
}
