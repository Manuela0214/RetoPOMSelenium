package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.SearchProductPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchProductTest {

    protected WebDriver driver;
    protected SearchProductPage searchProductPage;

    @BeforeEach
    public void setUp() {
        searchProductPage = new SearchProductPage(driver);
        driver = searchProductPage.chromeDriverConnection();
        searchProductPage.visitPage("https://automationexercise.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchProductTest() {
        assertTrue(searchProductPage.getTitle().contains("Automation Exercise"));
        searchProductPage.goToProductsPage();
        assertTrue(searchProductPage.isDisplayed(searchProductPage.getTitleSection()));
        assertEquals("ALL PRODUCTS", searchProductPage.getText(searchProductPage.getTitleSection()));
        searchProductPage.searchProduct("dress");
        assertEquals("SEARCHED PRODUCTS", searchProductPage.getText(searchProductPage.getTitleSection()));
        assertTrue(searchProductPage.verifyAllProductsAreVisible());
    }
}
