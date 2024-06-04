import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClassTask01 {

    //Class Task
    //-	Add Test cases for Inputs page (copy-paste from your other testNg project):
    //-			US101: Verify Input message
    //1.				Navigate to https://selenium-practice-app.herokuapp.com/?#/inputs
    //2.				Enter a message “Java is hard”
    //3.				Click ‘Show message’
    //4.				Verify message is displayed
    //-			US102: Verify Input message
    //1.				Navigate to https://selenium-practice-app.herokuapp.com/?#/inputs
    //2.				Enter a message “It’s possible to get better in Java”
    //3.				Click ‘Show message’
    //4.				Verify message is displayed
    //-			US103: Verify Input message
    //1.				Navigate to https://selenium-practice-app.herokuapp.com/?#/inputs
    //2.				Enter a message “I have to try harder to get better”
    //3.				Click ‘Show message’
    //4.				Verify message is displayed
    //		NOTE: Add @BeforeMethod and @AfterMethod

    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://selenium-practice-app.herokuapp.com/?#/inputs");
    }

    @AfterMethod( alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    @Test(testName = "Input message")
    public void US101(){
        driver.findElement(By.id("message")).sendKeys("Java is hard");
        driver.findElement(By.name("button1")).click();
        String expectedOutput = "Java is hard";
        String actualOutput = driver.findElement(By.name("message1")).getText();
        Assert.assertEquals(actualOutput,expectedOutput);
    }

    @Test(testName = "Input message")
    public void US102(){
        driver.findElement(By.id("message")).sendKeys("It's possible to get better in Java");
        driver.findElement(By.name("button1")).click();
        String expectedOutput = "It's possible to get better in Java";
        String actualOutput = driver.findElement(By.name("message1")).getText();
        Assert.assertEquals(actualOutput,expectedOutput);
    }

    @Test(testName = "Input message")
    public void US103(){
        driver.findElement(By.id("message")).sendKeys("I have to try harder to get better");
        driver.findElement(By.name("button1")).click();
        String expectedOutput = "I have to try harder to get better";
        String actualOutput = driver.findElement(By.name("message1")).getText();
        Assert.assertEquals(actualOutput,expectedOutput);
    }
}
