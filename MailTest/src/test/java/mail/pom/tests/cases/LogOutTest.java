package mail.pom.tests.cases;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import mail.logging.LoggingMessages;
import mail.pom.pages.YandexMainPage;
import mail.pom.tests.BasicTestClass;

public class LogOutTest extends BasicTestClass {

    private YandexMainPage yandexMainPage;

    @Test(groups = { "other-functions" }, priority = 10)
    public void logOut() {
	// TODO: Если уж ты решил прологировать каждое действие в тесте, то разделяй эти
	// шаги пробелами
	logger.info(LoggingMessages.CKICK_USER_ICON_MESSAGE);
	inboxPage.overallButtonsOnPages.clickUserNameIcon();

	logger.info(LoggingMessages.LOGOUT_MESSAGE);
	yandexMainPage = inboxPage.overallButtonsOnPages.logout();

	logger.info(LoggingMessages.ASSERT_LOGOUT_MESSAGE);
	try {
	    assertTrue(yandexMainPage.IsDisplayedEnterButton(), LoggingMessages.FAILURE_VERIFY_LOOUT_MESSAGE);
	} catch (AssertionError e) {
	    logger.error(e.getMessage());
	    fail(e.getMessage());
	}
    }

}
