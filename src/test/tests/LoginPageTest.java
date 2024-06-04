package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class LoginPageTest extends BaseTest {
    @BeforeMethod
    public void setUp1(){
        driver.get("https://selenium-practice-app.herokuapp.com/?#/usermgt");
        driver.findElement(By.id("practice-form")).click();
        new BrowserUtils(driver).switchToNextWindow();

    }

    @Test
    public void US701() {
        //driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[1]);
        driver.findElement(By.name("username")).sendKeys("john.snow@north.com");
        driver.findElement(By.name("password")).sendKeys("john.snow$");
        driver.findElement(By.tagName("button")).click();
        String expectedUrl = "https://selenium-practice-app.herokuapp.com/?#/user";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
