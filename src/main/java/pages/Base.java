package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Base {

    String homePath = "C:/Selenium/chromewebdriver/chrome-win64/chrome.exe";
    String workPath = "D:/Automated Testing/chromedriver.exe";

    public static WebDriver driver;

    @BeforeTest
    public void initializeDriver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        openPage();
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }

    //ПРОВЕРКА ЧТО ОТКРЫЛАСЬ НУЖНАЯ СТРАНИЦА
    public void checkTitle() {
        String titleActual = driver.getTitle();
        String titleExpected = "Agile Travel";

        Assert.assertEquals(titleActual, titleExpected);
        System.out.println("Page title verified");
    }

    // НАЧАЛО ТЕСТА - ОТКРЫТИЕ СТРАНИЦЫ
    public void openPage() {
        driver.get("https://travel.agileway.net/login");
        checkTitle();
    }
}
