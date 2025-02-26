package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Logger;

public class SearchProductPage extends Base {

    private static final Logger logger = Logger.getLogger(SearchProductPage.class.getName());

    public SearchProductPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[@href='/products']")
    private WebElement productsBtn;
    @FindBy(how = How.XPATH, using = "//h2[@class='title text-center']")
    private WebElement titleSection;
    @FindBy(how = How.XPATH, using = "//input[@id='search_product']")
    private WebElement searchBox;
    @FindBy(how = How.XPATH, using = "//button[@id='submit_search']")
    private WebElement searchBtn;
    @FindBy(how = How.XPATH, using = "//div[@class='overlay-content']/p")
    private List<WebElement> items;
    @FindBy(how = How.XPATH, using = "//div[@class='footer-widget']")
    private WebElement footerSection;

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
        logger.warning(items.toString());
        if (items.isEmpty()) {
            logger.warning("No se encontraron productos en los resultados de búsqueda.");
            return false;
        }
        scrollToElement(footerSection);
        logger.info("Todos los productos relacionados con la búsqueda son visibles.");
        return true;
    }

    public WebElement getTitleSection() {
        return titleSection;
    }
}
