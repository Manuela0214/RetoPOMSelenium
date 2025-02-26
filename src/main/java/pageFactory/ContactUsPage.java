package pageFactory;

import lombok.Getter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class ContactUsPage extends Base {

    private static final Logger logger = Logger.getLogger(ProductCarPage.class.getName());

    public ContactUsPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @Getter
    @FindBy(how = How.XPATH, using = "//h2[@class='title text-center']")
    private WebElement titleSection;
    @FindBy(how = How.XPATH, using = "//a[@href='/contact_us']")
    private WebElement contactButton;
    @Getter
    @FindBy(how = How.XPATH, using = "//h2[@class='title text-center' and contains(., 'Get In Touch')]")
    private WebElement getInTouchTitle;
    @FindBy(how = How.XPATH, using = "//input[@name='name']")
    private WebElement inputName;
    @FindBy(how = How.XPATH, using = "//input[@name='email']")
    private WebElement inputEmail;
    @FindBy(how = How.XPATH, using = "//input[@name='subject']")
    private WebElement inputSubject;
    @FindBy(how = How.XPATH, using = "//textarea[@name='message']")
    private WebElement inputMessage;
    @FindBy(how = How.XPATH, using = "//input[@name='upload_file']")
    private WebElement uploadFile;
    @FindBy(how = How.XPATH, using = "//input[@name='submit']")
    private WebElement submitBtn;
    @Getter
    @FindBy(how = How.XPATH, using = "//div[@class='status alert alert-success']")
    private WebElement successMessage;
    @FindBy(how = How.XPATH, using = "//a[@class='btn btn-success']")
    private WebElement homeBtn;

    public void goToContactUsPage() {
        click(contactButton);
        if (isDisplayed(getInTouchTitle)){
            logger.info("Navegación a la página de 'CONTACT US' exitosa.");
        }else{
        logger.warning("Fallo en la navegación a 'CONTACT US.");
        }
    }

    public void contactMessage(){
        clearText(inputName);
        typeText(inputName, "pepito");
        clearText(inputEmail);
        typeText(inputEmail, "pepito@gmail.com");
        clearText(inputSubject);
        typeText(inputSubject, "mensaje de pepito");
        clearText(inputMessage);
        typeText(inputMessage, "pepito quiere contactarse con ustedes");
        typeText(uploadFile, "C:\\Users\\ASUS\\Desktop\\Demo_archivo_prueba.txt");
        scrollToElement(submitBtn);
        click(submitBtn);
    }

    public void acceptSubmitMessage(){
        Alert alert = waitForAlert(5);
        alert.accept();
    }

    public void goToHomePage(){
        implicitWait(3);
        click(homeBtn);
    }

}
