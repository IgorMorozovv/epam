package mail.pom.tests.cases;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mail.buisnes.GeneralActions;
import mail.buisnes.LoginLogout;
import mail.data.EmailDataProvider;
import mail.logging.LoggingMessages;

public class CreateDraftTest extends GeneralActions {

    @BeforeMethod
    public void setUp() throws MalformedURLException {
	setDriver();
	try {
	    Thread.sleep(2000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	loginLogout = new LoginLogout(driver);
	logger = Logger.getLogger(CreateDraftTest.class);

    }

    @Test(groups = "basic-functions", dataProvider = "data", dataProviderClass = EmailDataProvider.class, priority = 1)
    public void createMessage(String receiver, String subject, String message) {

	inboxPage = loginLogout.logIn();

	fillFields(receiver, subject, message);
	saveLetterAsDraft();

	logger.info(LoggingMessages.ASSERT_CREATE_DRAFT_MESSAGE);
	assertTrue(writeLetterPage.getSavedTextArea().isDisplayed(),
		LoggingMessages.FAILURE_VERIFY_CREATE_DRAFT_MESSAGE);

	logger.info(LoggingMessages.GO_TO_MESSAGE + LoggingMessages.INBOX_MESSAGE);
	inboxPage.linksToMainPages.clickInboxLink().waitTitle();

	deleteAllDrafts();
	loginLogout.logout();
    }

    @AfterMethod(alwaysRun = true)
    public void afterClass() {

	logger.info(LoggingMessages.END_TEST_MESSAGE + getClass().getName());
	driver.close();
	driver = null;
    }

}
