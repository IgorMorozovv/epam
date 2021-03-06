package mail.pom.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mail.configuration.LoginConfiguration;
import mail.pom.pages.main.InboxPage;

public class LoginPage extends BasicPage {

    private String login = LoginConfiguration.LOGIN;
    private String password = LoginConfiguration.PASSWORD;
    private String loginPageURL = LoginConfiguration.LOGIN_URL;
    private final static String SCRIPT = "var elements = document.getElementsByClassName('passport-Button-Text');"
	    + "elements[0].click();";

    private JavascriptExecutor js;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "passwd")
    private WebElement passwordField;

    @FindBy(css = "button.passport-Button")
    private WebElement enterButton;

    public LoginPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	js = ((JavascriptExecutor) driver);
    }

    public void inputLogin(String login) {
	new Actions(driver).sendKeys(loginField, login).build().perform();
    }

    public void inputPassword(String password) {
	new Actions(driver).sendKeys(passwordField, password).build().perform();
    }

    public InboxPage clickEnter() {
	js.executeScript(SCRIPT);
	return new InboxPage(driver);
    }

    public void fillAccountData() {
	driver.get(loginPageURL);
	try {
	    inputLogin(login);
	} catch (Exception e) {
	    // TODO: handle exception
	}
	inputPassword(password);
    }

}
