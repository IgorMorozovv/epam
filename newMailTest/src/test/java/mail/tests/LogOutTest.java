package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import mail.logging.LoggingMessages;
import mail.pages.YandexMainPage;

public class LogOutTest extends BasicTestClass {

    private YandexMainPage yandexMainPage;

    @Test(groups = { "other-functions" }, priority = 10)
    public void logOut() {
	logger.info(LoggingMessages.START_MESSAGE + this.toString());
	inboxPage.waitTitle();
	inboxPage.overallButtonsOnPages.clickUserNameIcon();
	yandexMainPage = inboxPage.overallButtonsOnPages.logout();
	assertTrue(yandexMainPage.IsDisplayedEnterButton());
    }

}
