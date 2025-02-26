package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;

public class ProductCarPage extends Base{

    private static final Logger logger = Logger.getLogger(ProductCarPage.class.getName());

    public ProductCarPage(WebDriver driver) {
        super(driver);
    }

    By productsBtn = By.xpath("//a[@href='/products']");
    @Getter
    By titleSection = By.xpath("//h2[@class='title text-center']");
    By firstItem = By.xpath("//div[@class='features_items']/div[2]");
    By addToCartBtnFirstItem = By.xpath("//div[@class='features_items']/div[2]//div[@class='product-overlay']//a[@data-product-id='1']");
    By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
    By secondItem = By.xpath("//div[@class='features_items']/div[3]");
    By addToCartBtnSecondItem = By.xpath("//div[@class='features_items']/div[3]//div[@class='product-overlay']//a[@data-product-id='2']");
    By viewCartBtnModal = By.xpath("//div[@class='modal-body']//a[@href='/view_cart']");
    @Getter
    By firstItemCar = By.xpath("//tr[@id='product-1']//h4/a[contains(text(), 'Blue Top')]");
    @Getter
    By secondItemCar = By.xpath("//tr[@id='product-2']//h4/a[contains(text(), 'Men Tshirt')]");
    @Getter
    By priceFirstItem = By.xpath("//tr[@id='product-1']/td[@class='cart_price']/p");
    @Getter
    By priceSecondItem = By.xpath("//tr[@id='product-2']/td[@class='cart_price']/p");
    @Getter
    By quantityFirstItem = By.xpath("//tr[@id='product-1']/td[@class='cart_quantity']/button");
    @Getter
    By quantitySecondItem = By.xpath("//tr[@id='product-1']/td[@class='cart_quantity']/button");
    @Getter
    By totalFirstProduct = By.xpath("//tr[@id='product-1']/td[@class='cart_total']/p");
    @Getter
    By totalSecondProduct = By.xpath("//tr[@id='product-2']/td[@class='cart_total']/p");

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
