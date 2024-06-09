package tests;

import data.pojos.ExistingUser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserMgtPage;
import utils.BrowserUtils;

public class LoginPageTest extends BaseTest {
    private UserMgtPage page1;
    private LoginPage page2;

    ExistingUser user = new ExistingUser("john.snow@north.com", "john.snow$");

    @BeforeMethod
    public void setUp1(){
        driver.get("https://selenium-practice-app.herokuapp.com/?#/usermgt");
        page1 = new UserMgtPage(driver);
        page2 = new LoginPage(driver);
        page1.loginWindow.click();
        new BrowserUtils(driver).switchToNextWindow();
    }

    @Test
    public void US701() {
        page2.fillOutLoginCredentials(user.getUsernameCredential(), user.getPasswordCredential());
        String expectedUrl = "https://selenium-practice-app.herokuapp.com/?#/user";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
