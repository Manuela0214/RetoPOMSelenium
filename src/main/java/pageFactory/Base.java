package pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Base {

    protected static WebDriver driver;

    public Base() {
    }

    public static WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public static void visitPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void clearText(WebElement element) {
        element.clear();
    }

    public void typeText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        element.click();
    }

    public Boolean isDisplayed(WebElement element) {
        try{
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void implicitWait(int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public void waitUntilElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Alert waitForAlert(int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void scrollToElement(WebElement element){
        Actions action = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        action.moveToElement(element).perform();
    }
}
