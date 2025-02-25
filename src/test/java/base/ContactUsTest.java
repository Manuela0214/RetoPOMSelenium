package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsTest {

    protected WebDriver driver;
    protected ContactUsPage contactUsPage;

    @BeforeEach
    public void setUp() {
        contactUsPage = new ContactUsPage(driver);
        driver = contactUsPage.chromeDriverConnection();
        contactUsPage.visitPage("https://automationexercise.com/");
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
