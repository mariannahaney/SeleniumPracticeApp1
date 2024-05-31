import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class AllTests {
    @Test(testName = "Verify header of the page")
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium-practice-app.herokuapp.com/?#/home");
        Assert.assertEquals(driver.getTitle(), "TLA Automation");
        driver.close();
    }

    @Test(testName = "Verify number of nav buttons equal to 18")
    public void test02(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium-practice-app.herokuapp.com/?#/home");

        List<WebElement> elements = driver.findElements(By.xpath("//a[contains(@class, 'navbar-brand')]"));
        Assert.assertEquals(elements.size(), 18);

        driver.close();
    }

    @Test(testName = "Verify footer text")
    public void test03(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium-practice-app.herokuapp.com/?#/home");

        Assert.assertTrue(driver.findElement(By.id("copyright")).getText().contains("Tech Lead Academy"));

        driver.close();
    }
    @DataProvider(name = "roles")
    public Object[] data2(){
        Object[] roles = new String[] {"Mentor", "Student", "Instructor"};
        return roles;
    }

    @Test(testName = "US1010: Staging table view", dataProvider = "roles")
    public void test01(String role){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.findElement(By.xpath("//nav/a[text()='User-Mgt']")).click();

        driver.findElement(By.id("Firstname")).sendKeys("John");
        driver.findElement(By.id("Lastname")).sendKeys("Smith");
        driver.findElement(By.id("Phonenumber")).sendKeys("123-456-7890");
        driver.findElement(By.id("Email")).sendKeys("j.smith@test.com");
        driver.findElement(By.id("Select-role")).sendKeys(role);
        driver.findElement(By.id("submit-btn")).click();


        Assert.assertEquals(driver.findElement(By.xpath("//td[1]")).getText(), "John");
        Assert.assertEquals(driver.findElement(By.xpath("//td[2]")).getText(), "Smith");
        Assert.assertEquals(driver.findElement(By.xpath("//td[3]")).getText(), "123-456-7890");
        Assert.assertEquals(driver.findElement(By.xpath("//td[4]")).getText(), "j.smith@test.com");
        Assert.assertEquals(driver.findElement(By.xpath("//td[5]")).getText(), role);
    }

    @Test(testName = "US1010: Staging table view - DB check", dataProvider = "roles", groups = "smoke")
    public void test02(String role){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.findElement(By.xpath("//nav/a[text()='User-Mgt']")).click();

        driver.findElement(By.id("Firstname")).sendKeys("John");
        driver.findElement(By.id("Lastname")).sendKeys("Smith");
        driver.findElement(By.id("Phonenumber")).sendKeys("123-456-7890");
        driver.findElement(By.id("Email")).sendKeys("j.smith@test.com");
        driver.findElement(By.id("Select-role")).sendKeys(role);
        driver.findElement(By.id("submit-btn")).click();

        //accessing db page
        driver.findElement(By.id("access-db-btn")).click();
        //switch to db window
        for(String each: driver.getWindowHandles()){
            if (!each.equals(driver.getWindowHandle()))
                driver.switchTo().window(each);
        }

        //validate user email doesn't exist
        String xpath = "//td[text()='j.smith@test.com']";

        //using list to avoid NoSuchElementException, which would stop the execution and not reach Assertion
        List<WebElement> elementList = driver.findElements(By.xpath(xpath));
        Assert.assertEquals(elementList.size(), 0);
    }

    @Test(testName = "US1012: Adding user to DB", dataProvider = "roles")
    public void test05(String role){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.findElement(By.xpath("//nav/a[text()='User-Mgt']")).click();

        driver.findElement(By.id("Firstname")).sendKeys("John");
        driver.findElement(By.id("Lastname")).sendKeys("Smith");
        driver.findElement(By.id("Phonenumber")).sendKeys("123-456-7890");
        driver.findElement(By.id("Email")).sendKeys("j.smith@test.com");
        driver.findElement(By.id("Select-role")).sendKeys(role);
        driver.findElement(By.id("submit-btn")).click();

        //submitting table to db
        driver.findElement(By.id("submit-table-btn")).click();

        //validating table contains new email

    }










}
