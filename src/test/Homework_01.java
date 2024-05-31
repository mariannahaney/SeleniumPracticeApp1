import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework_01 {

//    HOMEWORK:
//            -		Navigate to Inputs page: https://selenium-practice-app.herokuapp.com/?#/inputs
//            -		Fill out the form using Faker class
//-		Verify message “Thanks for contacting us, we will get back to you shortly.” is displayed

    @Test(testName = "Contact Form")
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium-practice-app.herokuapp.com/?#/inputs");

        Faker faker = new Faker();

        String first = faker.name().firstName();
        String last = faker.name().lastName();
        String email = first.charAt(0) + last + "@test.com";
        String phoneNum = faker.phoneNumber().cellPhone();
        String address = faker.address().streetAddress();
        String city = faker.address().cityName();
        String zipCode = faker.address().zipCode();

        driver.findElement(By.name("first_name")).sendKeys(first);
        driver.findElement(By.name("last_name")).sendKeys(last);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys(phoneNum);
        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("zip")).sendKeys(zipCode);

        Select select = new Select(driver.findElement(By.name("state")));
        select.selectByVisibleText("Georgia");

        driver.findElement(By.name("button3")).click();
        Assert.assertEquals(driver.findElement(By.name("answer3")).getText(),
                "Thanks for contacting us, we will get back to you shortly.");

        driver.quit();

    }
}
