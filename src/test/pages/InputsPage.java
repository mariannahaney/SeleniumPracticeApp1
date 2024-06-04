package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputsPage {

    public InputsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "message")
    public WebElement inputField;

    @FindBy(name = "button1")
    public WebElement showMessageButton;

    @FindBy(name = "message1")
    public WebElement outputText;

}
