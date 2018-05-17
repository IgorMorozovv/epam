package mail.buisnes;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import mail.logging.LoggingMessages;
import mail.pom.pages.LoginPage;
import mail.pom.pages.YandexMainPage;
import mail.pom.pages.main.InboxPage;

public class LoginLogout {

    private WebDriver driver;
    private LoginPage loginPage;
    private InboxPage inboxPage;
    private Logger logger = Logger.getLogger(getClass());

    public LoginLogout(WebDriver driver) {
	this.driver = driver;
	loginPage = new LoginPage(driver);
    }

    public InboxPage logIn() {
	loginPage = new LoginPage(driver);

	logger.info(LoggingMessages.ENTER_PAGE_MESSAGE);
	loginPage.fillAccountData();

	logger.info(LoggingMessages.ENTER_BUTTON_CLICK_MESSAGE);
	inboxPage = (InboxPage) loginPage.clickEnter().waitTitle();
	return inboxPage;
    }

    public YandexMainPage logout() {
	logger.info(LoggingMessages.CKICK_USER_ICON_MESSAGE);
	inboxPage.overallButtonsOnPages.clickUserNameIcon();

	logger.info(LoggingMessages.LOGOUT_MESSAGE);
	return inboxPage.overallButtonsOnPages.logout();
    }

}
