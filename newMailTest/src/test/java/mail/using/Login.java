package mail.using;

import org.openqa.selenium.WebDriver;

import mail.pages.LoginPage;

//TODO: этот класс является бизнес-объектом. Не страницы должны быть полями этого класса, а этот класс следует сделать полем страницы LoginPage
// чтобы в тесте затем использовать LoginPage. Лучше было бы назвать этот класс Account и сделать метод заполнения полей логин и пароль - fillAccountData, и т д.
// А в классе страницы сделать метод login, который будет использовать метод fillAccountData и после делать clickEnter.
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

    // TODO: Переименуй в login()
    public void log() {

	driver.get(loginPageURL);
	loginPage.inputLogin(login);
	loginPage.inputPassword(password);
	loginPage.clickEnter();

    }

}
