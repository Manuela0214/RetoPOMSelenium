package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;

public class ProductCarPage extends Base{

    private static final Logger logger = Logger.getLogger(ProductCarPage.class.getName());

    public ProductCarPage(WebDriver driver) {
        super(driver);
    }

    By productsBtn = By.xpath("//a[@href='/products']");
    By titleSection = By.xpath("//h2[@class='title text-center']");
    By firstItem = By.xpath("//div[@class='features_items']/div[2]");
    By addToCartBtnFirstItem = By.xpath("//div[@class='features_items']/div[2]//div[@class='product-overlay']//a[@data-product-id='1']");
    By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
    By secondItem = By.xpath("//div[@class='features_items']/div[3]");
    By addToCartBtnSecondItem = By.xpath("//div[@class='features_items']/div[3]//div[@class='product-overlay']//a[@data-product-id='2']");
    By viewCartBtnModal = By.xpath("//div[@class='modal-body']//a[@href='/view_cart']");
    By firstItemCar = By.xpath("//tr[@id='product-1']//h4/a[contains(text(), 'Blue Top')]");
    By secondItemCar = By.xpath("//tr[@id='product-2']//h4/a[contains(text(), 'Men Tshirt')]");
    By priceFirstItem = By.xpath("//tr[@id='product-1']/td[@class='cart_price']/p");
    By priceSecondItem = By.xpath("//tr[@id='product-2']/td[@class='cart_price']/p");
    By quantityFirstItem = By.xpath("//tr[@id='product-1']/td[@class='cart_quantity']/button");
    By quantitySecondItem = By.xpath("//tr[@id='product-1']/td[@class='cart_quantity']/button");
    By totalFirstProduct = By.xpath("//tr[@id='product-1']/td[@class='cart_total']/p");
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

    public By getTitleSection() {
        return titleSection;
    }

    public By getFirstItemCar() {
        return firstItemCar;
    }

    public By getSecondItemCar() {
        return secondItemCar;
    }

    public By getPriceFirstItem() {
        return priceFirstItem;
    }

    public By getPriceSecondItem() {
        return priceSecondItem;
    }

    public By getQuantityFirstItem() {
        return quantityFirstItem;
    }

    public By getQuantitySecondItem() {
        return quantitySecondItem;
    }

    public By getTotalFirstProduct() {
        return totalFirstProduct;
    }

    public By getTotalSecondProduct() {
        return totalSecondProduct;
    }
}
