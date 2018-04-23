package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class LogOutTest extends BasicTestClass {

    @Test(groups = { "other-functions" }, priority = 10)
    public void logOut() {
	login.log();
	inboxPage.waitTitle();
	commonButtons.clickUserName();
	commonButtons.logout();
	assertTrue(yandexMainPage.enterButtonIsDisplay());
    }
}
