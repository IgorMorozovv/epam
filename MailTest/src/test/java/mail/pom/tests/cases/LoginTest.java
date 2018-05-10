package mail.pom.tests.cases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import jdk.internal.jline.internal.Log;
import mail.logging.LoggingMessages;
import mail.pom.tests.BasicTestClass;

public class LoginTest extends BasicTestClass {

    @Test(groups = "basic-functions", priority = 0)
    public void login() {	
	assertTrue(inboxPage.isTitleLoad(), "Не удалось войти в почту");
	logger.info("Успешный вход в почту");
    }

}
