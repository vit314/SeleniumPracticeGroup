package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends Base{
    public PaymentPage(WebDriver driver) {
        AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }

    // Locators for payment details
    By cardType = By.xpath("//input[@value='visa']");
    By cardNumberField = By.name("card_number");
    By expiryYearDropdown = By.name("expiry_year");
    By payNowButton = By.xpath("//input[@value='Pay now']");
    By bookingNumber = By.id("booking_number");

    // Method to enter payment details and get booking number
    public String enterPaymentDetailsAndPay(String cardNumber, String expiryYear) {
        driver.findElement(cardType).click();
        driver.findElement(cardNumberField).sendKeys(cardNumber);
        new Select(driver.findElement(expiryYearDropdown)).selectByVisibleText(expiryYear);
        driver.findElement(payNowButton).click();
        return driver.findElement(bookingNumber).getText();
    }
}

