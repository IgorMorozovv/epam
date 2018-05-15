package mail.pom.tests.cases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import mail.logging.LoggingMessages;
import mail.pom.pages.main.DraftPage;
import mail.pom.pages.write.LetterFieldsAssert;
import mail.pom.tests.common.GeneralActions;
import mail.utility.EmailDataProvider;

public class VerifyDraftsTests extends GeneralActions {

    private LetterFieldsAssert letterFieldsAssert;

    @BeforeClass
    public void setUp() {
	deleteAllDrafts();
    }

    @Test(groups = {
	    "other-functions" }, dataProvider = "data", dataProviderClass = EmailDataProvider.class, priority = 2)
    private void verifyDraft(String receiver, String subject, String message) {
	fillFields(receiver, subject, message);
	saveLetterAsDraft();
	refresh();

	logger.info(LoggingMessages.TO_FIRST_DRAFT_MESSAGE);
	draftPage = (DraftPage) inboxPage.linksToMainPages.clickDraftLink().waitTitle();
	letterFieldsAssert = draftPage.clickFirstDraft();

	logger.info(LoggingMessages.ASSERT_FILL_FIELDS_MESSAGE);
	assertEquals(receiver, letterFieldsAssert.getReceiver(), LoggingMessages.FAILURE_VERIFY_FIELDS_DRAFT_MESSAGE);
	assertEquals(subject, letterFieldsAssert.getSubject(), LoggingMessages.FAILURE_VERIFY_FIELDS_DRAFT_MESSAGE);
	assertEquals(message, letterFieldsAssert.getMessage(), LoggingMessages.FAILURE_VERIFY_FIELDS_DRAFT_MESSAGE);

	draftPage.linksToMainPages.clickInboxLink().waitTitle();
    }

    @AfterClass
    public void deleteDrafts() {
	deleteAllDrafts();
    }

}
