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
	logger.info(LoggingMessages.CKICK_USER_ICON_MESSAGE);
	inboxPage.overallButtonsOnPages.clickUserNameIcon();
	logger.info(LoggingMessages.LOGOUT_MESSAGE);
	yandexMainPage = inboxPage.overallButtonsOnPages.logout();
	try {
	    assertTrue(yandexMainPage.IsDisplayedEnterButton(), "Выход из почты не удался");
	} catch (AssertionError e) {
	    logger.error(e.getMessage());
	    fail(e.getMessage());
	}
    }

}
