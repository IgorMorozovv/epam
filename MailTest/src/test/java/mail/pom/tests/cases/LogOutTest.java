package mail.pom.tests.cases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import mail.logging.LoggingMessages;
import mail.pom.pages.YandexMainPage;
import mail.pom.tests.BasicTestClass;

public class LogOutTest extends BasicTestClass {

    private YandexMainPage yandexMainPage;

    @Test(groups = { "other-functions" }, priority = 10)
    public void logOut() {
	loginLogout.logIn();

	logger.info(LoggingMessages.ASSERT_LOGOUT_MESSAGE);
	yandexMainPage = loginLogout.logout();
	assertTrue(yandexMainPage.IsDisplayedEnterButton(), LoggingMessages.FAILURE_VERIFY_LOOUT_MESSAGE);

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
	logger.info(LoggingMessages.END_TEST_MESSAGE + getClass().getName());
	driver.close();
    }
}
