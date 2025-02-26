package pageFactory;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class ProductCarPage extends Base {

    private static final Logger logger = Logger.getLogger(ProductCarPage.class.getName());

    public ProductCarPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[@href='/products']")
    private WebElement productsBtn;
    @Getter
    @FindBy(how = How.XPATH, using = "//h2[@class='title text-center']")
    private WebElement titleSection;
    @FindBy(how = How.XPATH, using = "//div[@class='features_items']/div[2]")
    private WebElement firstItem;
    @FindBy(how = How.XPATH, using = "//div[@class='features_items']/div[2]//div[@class='product-overlay']//a[@data-product-id='1']")
    private WebElement addToCartBtnFirstItem;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue Shopping')]")
    private WebElement continueShoppingBtn;
    @FindBy(how = How.XPATH, using = "//div[@class='features_items']/div[3]")
    private WebElement secondItem;
    @FindBy(how = How.XPATH, using = "//div[@class='features_items']/div[3]//div[@class='product-overlay']//a[@data-product-id='2']")
    private WebElement addToCartBtnSecondItem;
    @FindBy(how = How.XPATH, using = "//div[@class='modal-body']//a[@href='/view_cart']")
    private WebElement viewCartBtnModal;
    @Getter
    @FindBy(how = How.XPATH, using = "//tr[@id='product-1']//h4/a[contains(text(), 'Blue Top')]")
    private WebElement firstItemCar;
    @Getter
    @FindBy(how = How.XPATH, using = "//tr[@id='product-2']//h4/a[contains(text(), 'Men Tshirt')]")
    private WebElement secondItemCar;
    @Getter
    @FindBy(how = How.XPATH, using = "//tr[@id='product-1']/td[@class='cart_price']/p")
    private WebElement priceFirstItem;
    @Getter
    @FindBy(how = How.XPATH, using = "//tr[@id='product-2']/td[@class='cart_price']/p")
    private WebElement priceSecondItem;
    @Getter
    @FindBy(how = How.XPATH, using = "//tr[@id='product-1']/td[@class='cart_quantity']/button")
    private WebElement quantityFirstItem;
    @Getter
    @FindBy(how = How.XPATH, using = "//tr[@id='product-1']/td[@class='cart_quantity']/button")
    private WebElement quantitySecondItem;
    @Getter
    @FindBy(how = How.XPATH, using = "//tr[@id='product-1']/td[@class='cart_total']/p")
    private WebElement totalFirstProduct;
    @Getter
    @FindBy(how = How.XPATH, using = "//tr[@id='product-2']/td[@class='cart_total']/p")
    private WebElement totalSecondProduct;

    public void goToProductsPage() {
        click(productsBtn);
        if(isDisplayed(titleSection)) {
            logger.info("Navegación a la página de 'ALL PRODUCTS' exitosa.");
        }else{
            logger.warning("Fallo en la navegación a 'ALL PRODUCTS'.");
        }
    }

    public void addToCart(){
        implicitWait(5);

        scrollToElement(firstItem);
        waitUntilElementClickable(addToCartBtnFirstItem);
        click(addToCartBtnFirstItem);
        click(continueShoppingBtn);

        scrollToElement(secondItem);
        waitUntilElementClickable(addToCartBtnFirstItem);
        click(addToCartBtnSecondItem);
        click(viewCartBtnModal);
    }

}
