package mail.pom.tests.cases;

import static org.testng.Assert.assertTrue;

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
	logger.info(LoggingMessages.START_MESSAGE + getClass().getName() );
	fillFields(receiver, subject, message);
	saveLetterAsDraft();
	refresh();
	draftPage.linksToMainPages.clickDraftLink();
	draftPage.waitTitle();
	draftPage.dropLetter();
	assertTrue(draftPage.isDisplayLackLettersText());
	draftPage.linksToMainPages.clickInboxLink();
	inboxPage.waitTitle();
    }

    @DataProvider
    private Object[][] letterData() {
	return dataReader.getData(FILE_NAME);
    }

}
