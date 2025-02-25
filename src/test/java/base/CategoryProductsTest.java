package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.CategoryProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryProductsTest {

    protected WebDriver driver;
    protected CategoryProductsPage categoryProductsPage;

    @BeforeEach
    public void setUp() {
        categoryProductsPage = new CategoryProductsPage(driver);
        driver = categoryProductsPage.chromeDriverConnection();
        categoryProductsPage.visitPage("https://automationexercise.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void categoryProductsTest() {
        assertTrue(categoryProductsPage.isDisplayed(categoryProductsPage.getTitleSection()));
        assertTrue(categoryProductsPage.isDisplayed(categoryProductsPage.getSideBarCategoryTitle()));
        categoryProductsPage.viewWomenProducts();
        assertTrue(categoryProductsPage.isDisplayed(categoryProductsPage.getTitleSection()));
        assertEquals("WOMEN - TOPS PRODUCTS", categoryProductsPage.getText(categoryProductsPage.getTitleSection()));
        categoryProductsPage.viewMenProducts();
        assertTrue(categoryProductsPage.isDisplayed(categoryProductsPage.getTitleSection()));
        assertEquals("MEN - TSHIRTS PRODUCTS", categoryProductsPage.getText(categoryProductsPage.getTitleSection()));
    }
}
