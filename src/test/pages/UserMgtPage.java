package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.UserMgtPageTest;

import java.util.List;

public class UserMgtPage {

    public UserMgtPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id= "practice-form")
    public WebElement loginWindow;

    @FindBy(id = "Firstname")
    public WebElement firstName;

    @FindBy(id = "Lastname")
    public WebElement lastName;

    @FindBy(id = "Phonenumber")
    public WebElement phoneNumber;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Select-role")
    public WebElement role;

    @FindBy(id = "submit-btn")
    public WebElement userMgtSubmitBtn;

    @FindBy(xpath = "//td[1]")
    public WebElement tempFirstName;

    @FindBy(xpath = "//td[2]")
    public WebElement tempLastName;

    @FindBy(xpath = "//td[3]")
    public WebElement tempPhoneNumber;

    @FindBy(xpath = "//td[4]")
    public WebElement tempEmail;

    @FindBy(xpath = "//td[5]")
    public WebElement tempRole;

    @FindBy(id = "access-db-btn")
    public WebElement accessDbBtn;

    @FindBy(id = "clear-btn")
    public WebElement clearBtn;

    @FindBy(xpath = "//table[@id='list-table']//td")
    public List<WebElement> tableOptions;

    @FindBy(id = "submit-table-btn")
    public WebElement submitTableBtn;

    @FindBy(id = "practice-form")
    public WebElement loginBtn;

    public void fillOutNewUserRegistrationForm(String first, String last, String phone, String emailAddress, String userRole){
        firstName.sendKeys(first);
        lastName.sendKeys(last);
        phoneNumber.sendKeys(phone);
        email.sendKeys(emailAddress);
        role.sendKeys(userRole);
        submitTableBtn.click();
    }
}
