package mail.pom.tests.cases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mail.logging.LoggingMessages;
import mail.pom.tests.common.GeneralActions;
import mail.utility.EmailDataProvider;

public class TransferDraft extends GeneralActions {

    @BeforeMethod
    public void deleteDrafts() {
	deleteAllDrafts();
    }

    @Test(groups = {
	    "other-functions" }, dataProvider = "data", dataProviderClass = EmailDataProvider.class, priority = 4)
    public void trancferDrafts(String receiver, String subject, String message) {
	fillFields(receiver, subject, message);
	saveLetterAsDraft();
	refresh();
	draftPage.linksToMainPages.clickDraftLink().waitTitle();
	draftPage.selectAllDrafts();

	logger.info(LoggingMessages.ASSERT_TRANSFER_LETTER_MESSAGE);
	draftPage.dropLetter();
	assertTrue(draftPage.isDisplayLackLettersText(), LoggingMessages.FAILURE_VERIFY_TRANSFER_DRAFT_MESSAGE);

	draftPage.linksToMainPages.clickInboxLink().waitTitle();
    }

}
