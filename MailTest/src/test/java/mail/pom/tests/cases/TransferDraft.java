package mail.pom.tests.cases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mail.buisnes.GeneralActions;
import mail.data.EmailDataProvider;
import mail.logging.LoggingMessages;

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

    @AfterClass(alwaysRun = true)
    public void afterClass() {
	logger.info(LoggingMessages.END_TEST_MESSAGE + getClass().getName());
	driver.close();
    }

}
