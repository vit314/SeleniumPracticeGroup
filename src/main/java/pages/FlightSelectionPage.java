package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FlightSelectionPage extends Base {
    public FlightSelectionPage(WebDriver driver) {
        AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }

    // Locators for flight selection
    By flightTime = By.xpath("//input[@type='checkbox']");
    By continueButton = By.xpath("//input[@value='Continue']");

    // Method to select flight
    public void selectFlight() throws InterruptedException {
        driver.findElement(flightTime).click();
        driver.findElement(continueButton).click();
    }
}

