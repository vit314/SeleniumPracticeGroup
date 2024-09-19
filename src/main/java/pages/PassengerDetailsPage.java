package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PassengerDetailsPage extends Base{
    public PassengerDetailsPage(WebDriver driver) {
        AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }

    // Locators for passenger details
    By firstNameField = By.name("passengerFirstName");
    By lastNameField = By.name("passengerLastName");
    By nextButton = By.xpath("//input[@value='Next']");

    // Method to enter passenger details
    public void enterPassengerDetails(String firstName, String lastName) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(nextButton).click();
    }
}

