package mail.using;

import org.openqa.selenium.WebDriver;

import mail.pages.LoginPage;

public class Login {
    LoginPage loginPage;
    WebDriver driver;
    private String login = LoginPageData.LOGIN;
    private String password = LoginPageData.PASSWORD;
    private String loginPageURL = LoginPageData.LOGIN_URL;

    public Login(WebDriver driver) {

	this.driver = driver;
	loginPage = new LoginPage(driver);

    }

    public void log() {

	driver.get(loginPageURL);
	loginPage.inputLogin(login);
	loginPage.inputPassword(password);
	loginPage.clickEnter();

    }

}
