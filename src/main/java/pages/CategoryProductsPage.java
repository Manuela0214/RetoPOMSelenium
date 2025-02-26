package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryProductsPage extends Base{

    public CategoryProductsPage(WebDriver driver) {
        super(driver);
    }

    @Getter
    By sideBarCategoryTitle = By.xpath("//div[@class='left-sidebar']/h2");
    By womenCategoryBtn = By.xpath("//a[@data-toggle='collapse' and contains(., 'Women')]");
    By dressCategoryBtn = By.xpath("//a[@href='/category_products/2' and contains(., 'Tops')]");
    @Getter
    By titleSection = By.xpath("//h2[@class='title text-center']");
    By menCategoryBtn = By.xpath("//a[@data-toggle='collapse' and contains(., 'Men')]");
    By tshirtsCategoryBtn = By.xpath("//a[@href='/category_products/3' and contains(., 'Tshirts ')]");

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

}
