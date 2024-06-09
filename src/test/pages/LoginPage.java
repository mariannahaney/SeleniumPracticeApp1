package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "username")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(tagName = "button")
    public WebElement loginButton;

    public void fillOutLoginCredentials(String userNameCredential, String passwordCredential){
        userName.sendKeys(userNameCredential);
        password.sendKeys(passwordCredential);
        loginButton.click();
    }
}
