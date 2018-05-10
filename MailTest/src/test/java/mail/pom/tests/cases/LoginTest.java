package mail.pom.tests.cases;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import mail.pom.tests.BasicTestClass;

public class LoginTest extends BasicTestClass {

    @Test(groups = "basic-functions", priority = 0)
    public void login() {
	try {
	    assertTrue(inboxPage.isTitleLoad(), "Не удалось войти в почту");
	} catch (AssertionError e) {
	    logger.error(e.getMessage());
	    fail(e.getMessage());
	}
    }

}
