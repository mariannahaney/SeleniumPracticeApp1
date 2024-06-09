package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SynchronizationPage;
import utils.BrowserUtils;

public class SynchronizationPageTest extends BaseTest {

    private SynchronizationPage synchronizationPage;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        synchronizationPage = new SynchronizationPage(driver);
        driver.findElement(By.linkText("Synchronization")).click();

    }

    @Test(testName = "US3101 - Verify alert pops up")
    public void US3101() {
        synchronizationPage.displayAlertBtn.click();
        new BrowserUtils(driver).waitUntilAlertIsPresent();
        driver.switchTo().alert();

    }
}
