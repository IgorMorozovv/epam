package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class LoginTest extends BasicTestClass {

    @Test(groups = "login", priority = 5)
    public void login() {

	login.log();

	assertTrue(inboxPage.isLoad());
    }
}
