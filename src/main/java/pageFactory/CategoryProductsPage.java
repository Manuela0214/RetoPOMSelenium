package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CategoryProductsPage extends Base {



    @FindBy(how = How.XPATH, using = "//div[@class='left-sidebar']/h2")
    private WebElement sideBarCategoryTitle;
    @FindBy(how = How.XPATH, using = "//a[@data-toggle='collapse' and contains(., 'Women')]")
    private WebElement womenCategoryBtn;
    @FindBy(how = How.XPATH, using = "//a[@href='/category_products/2' and contains(., 'Tops')]")
    private WebElement dressCategoryBtn;
    @FindBy(how = How.XPATH, using = "//h2[@class='title text-center']")
    private WebElement titleSection;
    @FindBy(how = How.XPATH, using = "//a[@data-toggle='collapse' and contains(., 'Men')]")
    private WebElement menCategoryBtn;
    @FindBy(how = How.XPATH, using = "//a[@href='/category_products/3' and contains(., 'Tshirts ')]")
    private WebElement tshirtsCategoryBtn;

    public CategoryProductsPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    public void viewWomenProducts(){
        implicitWait(5);
        click(womenCategoryBtn);
        click(dressCategoryBtn);
    }

    public void viewMenProducts(){
        implicitWait(5);
        click(menCategoryBtn);
        click(tshirtsCategoryBtn);
    }

    public WebElement getTitleSection() {
        return titleSection;
    }

    public WebElement getSideBarCategoryTitle() {
        return sideBarCategoryTitle;
    }
}
