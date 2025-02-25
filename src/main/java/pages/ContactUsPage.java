package pages;

import org.openqa.selenium.*;
import java.util.logging.Logger;

public class ContactUsPage extends Base{

    private static final Logger logger = Logger.getLogger(ProductCarPage.class.getName());

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    By titleSection = org.openqa.selenium.By.xpath("//h2[@class='title text-center']");
    By contactButton = By.xpath("//a[@href='/contact_us']");
    By getInTouchTitle = By.xpath("//h2[@class='title text-center' and contains(., 'Get In Touch')]");
    By inputName = By.xpath("//input[@name='name']");
    By inputEmail = By.xpath("//input[@name='email']");
    By inputSubject = By.xpath("//input[@name='subject']");
    By inputMessage = By.xpath("//textarea[@name='message']");
    By uploadFile = By.xpath("//input[@name='upload_file']");
    By submitBtn = By.xpath("//input[@name='submit']");
    By successMessage = By.xpath("//div[@class='status alert alert-success']");
    By homeBtn = By.xpath("//a[@class='btn btn-success']");

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

    public By getSuccessMessage() {
        return successMessage;
    }

    public By getTitleSection() {
        return titleSection;
    }

    public By getGetInTouchTitle() {
        return getInTouchTitle;
    }
}
