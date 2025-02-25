package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.ProductCarPage;

import static org.junit.jupiter.api.Assertions.*;

public class ProductCarPageTest {

    protected WebDriver driver;
    protected ProductCarPage productCarPage;

    @BeforeEach
    public void setUp() {
        productCarPage = new ProductCarPage(driver);
        driver = productCarPage.chromeDriverConnection();
        productCarPage.visitPage("https://automationexercise.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testProductCarPage(){
        assertTrue(productCarPage.getTitle().contains("Automation Exercise"));
        productCarPage.goToProductsPage();
        assertTrue(productCarPage.isDisplayed(productCarPage.getTitleSection()));
        assertEquals("ALL PRODUCTS", productCarPage.getText(productCarPage.getTitleSection()));
        productCarPage.addToCart();
        assertAll(
            () -> assertEquals("Blue Top", productCarPage.getText(productCarPage.getFirstItemCar())),
            () ->assertEquals("Men Tshirt", productCarPage.getText(productCarPage.getSecondItemCar())),
            () ->assertEquals("Rs. 500", productCarPage.getText(productCarPage.getPriceFirstItem())),
            () ->assertEquals("Rs. 400", productCarPage.getText(productCarPage.getPriceSecondItem())),
            () ->assertEquals("1", productCarPage.getText(productCarPage.getQuantityFirstItem())),
            () ->assertEquals("1", productCarPage.getText(productCarPage.getQuantitySecondItem())),
            () ->assertEquals("Rs. 500", productCarPage.getText(productCarPage.getTotalFirstProduct())),
            () ->assertEquals("Rs. 400", productCarPage.getText(productCarPage.getTotalSecondProduct()))
        );
    }

}
