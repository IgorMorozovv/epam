package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class LoginTest extends BasicTestClass {

    @Test(groups = "basic-functions", priority = 0)
    public void login() {
	assertTrue(inboxPage.isTitleLoad(), "Не удалось войти в почту");
	logger.info("Успешный вход в почту");
    }

}
