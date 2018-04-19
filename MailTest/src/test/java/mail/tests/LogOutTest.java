package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class LogOutTest extends BasicTestClass {

    @Test(dependsOnGroups = { "login" }, priority = 10)
    public void logOut() {
	login.log();
	getCommonButtons().clickUserName();
	getCommonButtons().logout();
	assertTrue(yandexMainPage.enterButtonIsDisplay());
    }
}
