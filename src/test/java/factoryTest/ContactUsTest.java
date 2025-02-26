package factoryTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageFactory.Base;
import pageFactory.ContactUsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsTest {

    protected WebDriver driver;
    protected ContactUsPage contactUsPage;

    @BeforeEach
    public void setUp() {
        driver = Base.chromeDriverConnection();
        Base.visitPage("https://automationexercise.com/");
        contactUsPage = new ContactUsPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void contactUsTest() {
        assertTrue(contactUsPage.getTitle().contains("Automation Exercise"));
        contactUsPage.goToContactUsPage();
        assertTrue(contactUsPage.isDisplayed(contactUsPage.getTitleSection()));
        assertEquals("GET IN TOUCH", contactUsPage.getText(contactUsPage.getGetInTouchTitle()));
        contactUsPage.contactMessage();
        contactUsPage.acceptSubmitMessage();
        assertEquals("Success! Your details have been submitted successfully.", contactUsPage.getText(contactUsPage.getSuccessMessage()));
        contactUsPage.goToHomePage();
        assertTrue(contactUsPage.getTitle().contains("Automation Exercise"));
    }
}
