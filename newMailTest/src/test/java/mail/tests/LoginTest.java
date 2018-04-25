package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import mail.pages.main.InboxPage;

public class LoginTest extends BasicTestClass {
   
    @Test(groups = "basic-functions", priority = 0)
    public void login() {
	assertTrue(inboxPage.isTitleLoad());
    }
}
