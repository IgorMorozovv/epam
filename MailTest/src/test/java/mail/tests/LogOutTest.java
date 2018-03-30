package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class LogOutTest extends Basic {

    @Test(dependsOnGroups = { "login" }, priority = 2)
    public void logOut() {
	mailPage.logOut();
	assertTrue(yandexMainPage.enterButtonIsDisplay());
    }
}
