package mail.pom.tests.cases;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import mail.logging.LoggingMessages;
import mail.pom.tests.common.GeneralActions;
import mail.utility.EmailDataProvider;

public class CreateDraftTest extends GeneralActions {

    @BeforeClass
    public void setUp() {
	logger = Logger.getLogger(CreateDraftTest.class);
    }

    @Test(groups = "basic-functions", dataProvider = "data", dataProviderClass = EmailDataProvider.class, priority = 1)
    public void createMessage(String receiver, String subject, String message) {
	fillFields(receiver, subject, message);
	saveLetterAsDraft();

	logger.info(LoggingMessages.ASSERT_CREATE_DRAFT_MESSAGE);
	assertTrue(writeLetterPage.getSavedTextArea().isDisplayed(),
		LoggingMessages.FAILURE_VERIFY_CREATE_DRAFT_MESSAGE);

	logger.info(LoggingMessages.GO_TO_MESSAGE + LoggingMessages.INBOX_MESSAGE);
	inboxPage.linksToMainPages.clickInboxLink().waitTitle();
    }

    @AfterClass
    private void deleteDrafts() {
	deleteAllDrafts();
    }

}
