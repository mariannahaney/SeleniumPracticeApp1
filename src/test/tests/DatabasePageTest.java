package tests;

import com.github.javafaker.Faker;
import data.pojos.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DatabasePage;
import pages.UserMgtPage;
import utils.BrowserUtils;


public class DatabasePageTest extends BaseTest{

    private  DatabasePage databasePage;
    private  UserMgtPage userMgtPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        databasePage = new DatabasePage(driver);
      userMgtPage = new UserMgtPage(driver);
        driver.findElement(By.xpath("//nav/a[text()='User-Mgt']")).click();

    }

    @Test(testName = "US2004 - New user's password format")
    public void US2004(String role) {
        Faker faker = new Faker();
        User user = new User(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().cellPhone(),
                "test@test.com", "Mentor"
        );
        report.logInfo(user);

        userMgtPage.fillOutNewUserRegistrationForm(user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(), role);
        userMgtPage.submitTableBtn.click();
        userMgtPage.accessDbBtn.click();
        new BrowserUtils(driver).switchToNextWindow();


    }
}
