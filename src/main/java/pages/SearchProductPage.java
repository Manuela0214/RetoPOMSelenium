package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.logging.Logger;

public class SearchProductPage extends Base{

    private static final Logger logger = Logger.getLogger(SearchProductPage.class.getName());

    public SearchProductPage(WebDriver driver) {
        super(driver);
    }

    By productsBtn = By.xpath("//a[@href='/products']");
    By titleSection = By.xpath("//h2[@class='title text-center']");
    By searchBox = By.xpath("//input[@id='search_product']");
    By searchBtn = By.xpath("//button[@id='submit_search']");
    By items = By.xpath("//div[@class='overlay-content']/p");
    By footerSection = By.xpath("//div[@class='footer-widget']");

    public void goToProductsPage() {
        click(productsBtn);
        if(isDisplayed(titleSection)) {
            logger.info("Navegación a la página de 'ALL PRODUCTS' exitosa.");
        }else{
            logger.warning("Fallo en la navegación a 'ALL PRODUCTS'.");
        }
    }

    public void searchProduct(String text) {
        clearText(searchBox);
        typeText(searchBox, text);
        click(searchBtn);
        if(isDisplayed(titleSection)){
            logger.info("La sección 'SEARCHED PRODUCTS' es visible.");
        }else{
            logger.warning("No se encontró la sección 'SEARCHED PRODUCTS'.");
        }
    }

    public boolean verifyAllProductsAreVisible() {
        List<WebElement> products = driver.findElements(items);
        logger.warning(products.toString());
        if (products.isEmpty()) {
            logger.warning("No se encontraron productos en los resultados de búsqueda.");
            return false;
        }
        WebElement footer = driver.findElement(footerSection);
        new Actions(driver)
                .scrollToElement(footer)
                .perform();

        logger.info("Todos los productos relacionados con la búsqueda son visibles.");
        return true;
    }

    public By getTitleSection() {
        return titleSection;
    }
}
