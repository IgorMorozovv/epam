package mail.tests.common;

import org.openqa.selenium.StaleElementReferenceException;

import mail.tests.BasicTestClass;

public class GeneralActions extends BasicTestClass {

    public void deleteAllDrafts() {
	refresh();
	try {
	    logger.info("");
	    inboxPage.linksToMainPages.clickDraftLink().waitTitle();
	    draftPage.selectAllDrafts();
	    draftPage.overallButtonsOnPages.clickDeleteButton();
	} catch (StaleElementReferenceException e) {
	    e.printStackTrace();
	}
    }

    public void fillFields(String receiver, String subject, String message) {
	writeLetterPage = inboxPage.overallButtonsOnPages.clickWriteMessageButton();
	writeLetterPage.fillToField(receiver);
	writeLetterPage.clickByMessageField();
	writeLetterPage.fillSubjectField(subject);
	writeLetterPage.fillMessageField(message);
    }

    public void saveLetterAsDraft() {
	writeLetterPage.saveLetterAsDraft();
    }

    public void refresh() {
	inboxPage.linksToMainPages.clickInboxLink();
	inboxPage.waitTitle();
	inboxPage.overallButtonsOnPages.clickRefreshButton();
	draftPage = inboxPage.linksToMainPages.clickDraftLink();
	draftPage.waitTitle();
    }

}
