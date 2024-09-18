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
    By tripTypeReturn = By.id("trip_type_return");
    By fromSelect = By.id("fromPort");
    By toSelect = By.id("toPort");
    By departingDay = By.id("depart_day");
    By departingMonthYear = By.id("depart_month");
    By returningDay = By.id("return_day");
    By returningMonthYear = By.id("return_month");
    By continueButton = By.name("commit");

    // Method to search flights
    public void searchFlight(String from, String to, String departDay, String departMonthYear, String returnDay, String returnMonthYear) {
        driver.findElement(tripTypeReturn).click();
        new Select(driver.findElement(fromSelect)).selectByVisibleText(from);
        new Select(driver.findElement(toSelect)).selectByVisibleText(to);
        driver.findElement(departingDay).sendKeys(departDay);
        driver.findElement(departingMonthYear).sendKeys(departMonthYear);
        driver.findElement(returningDay).sendKeys(returnDay);
        driver.findElement(returningMonthYear).sendKeys(returnMonthYear);
        driver.findElement(continueButton).click();
    }
}

