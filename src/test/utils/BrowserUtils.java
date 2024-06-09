package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.time.Duration;
import java.util.Set;

public class BrowserUtils extends BaseTest {

    private WebDriver driver;

    public BrowserUtils(WebDriver driver){
        this.driver = driver;
    }
    public void switchToNextWindow(){
        Set<String> set = driver.getWindowHandles();
        for (String each: set){
            if (!each.equals(driver.getWindowHandle()))
                driver.switchTo().window(each);
        }

    }

    public void waitUntilAlertIsPresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
    }

}
