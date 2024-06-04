package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InputsPage;

public class InputsPageTest extends BaseTest {

    private InputsPage page;

    @BeforeMethod
    public void setUp1(){
        page = new InputsPage(driver);
        driver.get("https://selenium-practice-app.herokuapp.com/?#/inputs");
    }

    @Test(testName = "Input message")
    public void US101(){
        page.inputField.sendKeys("Java is hard");
        page.showMessageButton.click();
        String expectedOutput = "Java is hard";
        String actualOutput = page.outputText.getText();
        Assert.assertEquals(actualOutput,expectedOutput);
    }

    @Test(testName = "Input message")
    public void US102(){

        page.inputField.sendKeys("It's possible to get better in Java");
        page.showMessageButton.click();
        String expectedOutput = "It's possible to get better in Java";
        String actualOutput = page.outputText.getText();
        Assert.assertEquals(actualOutput,expectedOutput);
    }

    @Test(testName = "Input message")
    public void US103(){
        page.inputField.sendKeys("I have to try harder to get better");
        page.showMessageButton.click();
        String expectedOutput = "I have to try harder to get better";
        String actualOutput = page.outputText.getText();
        Assert.assertEquals(actualOutput,expectedOutput);
    }
}
