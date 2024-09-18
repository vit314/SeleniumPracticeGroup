package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaymentPage extends Base{
    public PaymentPage(WebDriver driver) {
        AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }

    // Locators for payment details
    By cardNumberField = By.id("card_number");
    By cardExpiryField = By.id("expiry_date");
    By payNowButton = By.name("commit");
    By bookingNumber = By.xpath("//div[@class='notice']//strong");

    // Method to enter payment details and get booking number
    public String enterPaymentDetailsAndPay(String cardNumber, String expiryDate) {
        driver.findElement(cardNumberField).sendKeys(cardNumber);
        driver.findElement(cardExpiryField).sendKeys(expiryDate);
        driver.findElement(payNowButton).click();
        return driver.findElement(bookingNumber).getText();
    }
}

