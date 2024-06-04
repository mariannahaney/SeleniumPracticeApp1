package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class CalendarPageTest {

    //US1015: Choosing date from the calendar.
    //	Verify when user choses tomorrow as a date then “There are 1 days between today’s date and tomorrow’s date”.

    public String getTomorrowDate (LocalDate today){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return today.plus(Period.ofDays(1)).format(formatter);

    }
    WebDriver driver;

    @Test
    public void US1015() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String tomorrow = getTomorrowDate(LocalDate.now());
        driver.get("https://selenium-practice-app.herokuapp.com/?#/calendar");
        driver.manage().window().maximize();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, react-datepicker-wrapper)]")));
        driver.findElement(By.xpath("(//input)[2]")).click();
        driver.findElement(By.xpath("//input[@class='react-datepicker-ignore-onclickoutside']")).sendKeys(tomorrow);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        Assert.assertEquals(driver.findElement(By.id("num-days")).getText(),
                "There are 2 days between 02/06/2024 and 03/06/2024");

        driver.quit();
    }


    //- US1016: Choosing date from the calendar. Start date test.
    //Verify when user selects a date and clicks on Submit button the result text contains today’s date as default

    @Test
    public void US1016() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String tomorrow = getTomorrowDate(LocalDate.now());
        driver.get("https://selenium-practice-app.herokuapp.com/?#/calendar");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("(//input)[2]")).click();
        driver.findElement(By.xpath("//input[@class='react-datepicker-ignore-onclickoutside']")).
                sendKeys(tomorrow);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String today = LocalDate.now().format(formatter);
        driver.findElement(By.xpath("(//input)[1]")).click();
        String actualDate = driver.findElement(By.xpath(
                "//input[@class='react-datepicker-ignore-onclickoutside']")).getText();
        Assert.assertEquals(actualDate,today);

        driver.quit();
    }
}
