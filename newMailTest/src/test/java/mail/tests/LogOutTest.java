package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import mail.pages.YandexMainPage;
import mail.pages.main.InboxPage;

public class LogOutTest extends BasicTestClass {
    
    private InboxPage inboxPage;
    private YandexMainPage yandexMainPage;
    
    @BeforeClass
    public void setUp() {
	inboxPage = new InboxPage(driver);
	yandexMainPage = new YandexMainPage(driver);
	
    }
    @Test(groups = { "other-functions" }, priority = 10)
    public void logOut() {
	inboxPage.waitTitle();
	inboxPage.overallButtonsOnPages.clickUserNameIcon();
	inboxPage.overallButtonsOnPages.logout();
	assertTrue(yandexMainPage.IsDisplayedEnterButton());
    }
}
