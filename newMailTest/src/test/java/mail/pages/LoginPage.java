package mail.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final static String SCRIPT = "var elements = document.getElementsByClassName('passport-Button-Text');"
	    + "elements[0].click();";

    public LoginPage(WebDriver driver) {

	PageFactory.initElements(driver, this);
	this.driver = driver;
	js = ((JavascriptExecutor) driver);
    }

    JavascriptExecutor js;
    public WebDriver driver;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "passwd")
    private WebElement passwordField;

    @FindBy(css = "button.passport-Button")
    private WebElement enterButton;

    public void inputLogin(String login) {

	new Actions(driver).sendKeys(loginField, login).build().perform();
    }

    public void inputPassword(String password) {

	new Actions(driver).sendKeys(passwordField, password).build().perform();
    }

    public void clickEnter() {

	((JavascriptExecutor) driver).executeScript(SCRIPT);

    }

    public void clickLastDraft() {

    }

}
