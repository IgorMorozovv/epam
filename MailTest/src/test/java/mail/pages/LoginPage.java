package mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {

	PageFactory.initElements(driver, this);
	this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "passwd")
    private WebElement passwordField;

    @FindBy(css = "button.passport-Button")
    private WebElement enterButton;

    public void inputLogin(String login) {
	loginField.sendKeys(login);
    }

    public void inputPassword(String password) {
	passwordField.sendKeys(password);
    }

    public void clickEnter() {
	enterButton.click();
    }

    public void clickLastDraft() {

    }

}
