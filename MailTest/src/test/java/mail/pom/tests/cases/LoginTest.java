package mail.pom.tests.cases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import mail.logging.LoggingMessages;
import mail.pom.tests.BasicTestClass;

public class LoginTest extends BasicTestClass {

    @Test(groups = "basic-functions", priority = 0)
    public void login() {
	logger.info(LoggingMessages.ASSERT_LOGGING_MESSAGE);
	assertTrue(inboxPage.isTitleLoad(), LoggingMessages.FAILURE_VERIFY_LOGIN_MESSAGE);
    }

}
