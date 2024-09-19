package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends Base {
    public FlightSearchPage(WebDriver driver) {
        AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 60);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }

    // Locators for search elements
    By tripTypeReturn = By.name("tripType");
    By fromSelect = By.name("fromPort");
    By toSelect = By.name("toPort");
    By departingDay = By.id("departDay");
    By departingMonthYear = By.id("departMonth");
    By returningDay = By.id("returnDay");
    By returningMonthYear = By.id("returnMonth");
    By continueButton = By.xpath("//input[@value='Continue']");

    // Method to search flights
    public void searchFlight(String from, String to, String departDay, String departMonthYear, String returnDay, String returnMonthYear) {
//        driver.findElement(tripTypeReturn).click();
        new Select(driver.findElement(fromSelect)).selectByVisibleText(from);
        new Select(driver.findElement(toSelect)).selectByVisibleText(to);
        driver.findElement(departingDay).sendKeys(departDay);
        driver.findElement(departingMonthYear).sendKeys(departMonthYear);
        driver.findElement(returningDay).sendKeys(returnDay);
        driver.findElement(returningMonthYear).sendKeys(returnMonthYear);
        driver.findElement(continueButton).click();
    }
}

