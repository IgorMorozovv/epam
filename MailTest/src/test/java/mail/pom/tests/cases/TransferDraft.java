package mail.pom.tests.cases;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mail.logging.LoggingMessages;
import mail.pom.tests.common.GeneralActions;

public class TransferDraft extends GeneralActions {

    @BeforeMethod
    public void deleteDrafts() {
	deleteAllDrafts();
    }

    @Test(groups = { "other-functions" }, dataProvider = "letterData", priority = 4)
    public void trancferDrafts(String receiver, String subject, String message) {
	fillFields(receiver, subject, message);
	saveLetterAsDraft();
	refresh();
	draftPage.linksToMainPages.clickDraftLink().waitTitle();
	draftPage.selectAllDrafts();
	logger.info(LoggingMessages.ASSERT_TRANSFER_LETTER_MESSAGE);
	draftPage.dropLetter();

	try {
	    assertTrue(draftPage.isDisplayLackLettersText(), LoggingMessages.FAILURE_VERIFY_TRANSFER_DRAFT_MESSAGE);
	} catch (AssertionError e) {
	    logger.error(e.getMessage());
	    fail(e.getMessage());
	}

	draftPage.linksToMainPages.clickInboxLink();
	inboxPage.waitTitle();
    }

    @DataProvider
    private Object[][] letterData() {

	return dataReader.getData(FILE_NAME);
    }

}
