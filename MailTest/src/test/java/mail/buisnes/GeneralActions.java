package mail.buisnes;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

import mail.logging.LoggingMessages;
import mail.pom.tests.BasicTestClass;

public class GeneralActions extends BasicTestClass {

    public void deleteAllDrafts() {
	refresh();
	logger.info(LoggingMessages.DELETE_DRAFT_MESSAGE);
	try {
	    inboxPage.linksToMainPages.clickDraftLink().waitTitle();
	    draftPage.selectAllDrafts();
	    draftPage.overallButtonsOnPages.clickDeleteButton();
	} catch (StaleElementReferenceException | TimeoutException e) {
	    e.printStackTrace();
	    logger.error(e.getMessage());
	}
    }

    public void fillFields(String receiver, String subject, String message) {
	logger.info(LoggingMessages.FILL_FIELDS_MESSAGE);
	writeLetterPage = inboxPage.overallButtonsOnPages.clickWriteMessageButton().fillField(receiver)
		.clickByMessageField().fillSubjectField(subject).fillMessageField(message);
    }

    public void saveLetterAsDraft() {
	logger.info(LoggingMessages.SAVE_DRAFT_MESSAGE);
	writeLetterPage.saveLetterAsDraft();
    }

    public void refresh() {
	logger.info(LoggingMessages.REFRESH_MAIL_MESSAGE);
	inboxPage.linksToMainPages.clickInboxLink().waitTitle();
	inboxPage.overallButtonsOnPages.clickRefreshButton();
	draftPage = inboxPage.linksToMainPages.clickDraftLink();
	draftPage.waitTitle();
    }

}
