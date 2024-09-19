package tests;

import org.testng.annotations.Test;
import pages.*;
import org.openqa.selenium.WebDriver;


public class FlightBookingTest extends Base {

    WebDriver driver;

    @Test
    public void flightBookingTest() throws InterruptedException {

        // Page Object instances
        LoginPage loginPage = new LoginPage(driver);
        FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
        FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
        PassengerDetailsPage passengerDetailsPage = new PassengerDetailsPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);

        // Login to the website
        loginPage.login("agileway", "testwise");

        // Search for flights
        flightSearchPage.searchFlight(
                "New York", "Sydney",
                "01", "November 2024",
                "01", "December 2024"
        );

        //Select flight
//        flightSelectionPage.selectFlight();

       // Enter passenger details
        passengerDetailsPage.enterPassengerDetails("Vit", "Pav");

        // Enter payment details and get booking number
        String bookingNumber = paymentPage.enterPaymentDetailsAndPay("1111111111111111", "2027");

        // Print booking number
        System.out.println("Booking number: " + bookingNumber);

    }
}


