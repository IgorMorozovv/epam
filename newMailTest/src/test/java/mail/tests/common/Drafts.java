package mail.tests.common;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import mail.pages.main.DraftPage;
import mail.pages.main.InboxPage;
import mail.pages.write.WriteLetterPage;
import mail.tests.BasicTestClass;

public class Drafts extends BasicTestClass {

    public void deleteAllDrafts() {

	refresh();
	try {
	    draftPage.linksToMainPages.clickDraftLink();
	    draftPage.waitTitle();
	    draftPage.selectAllDrafts();
	    draftPage.overallButtonsOnPages.clickDeleteButton();
	} catch (StaleElementReferenceException e) {
	    e.printStackTrace();
	}
    }

    public void fillFields(String receiver, String subject, String message) {
	inboxPage.overallButtonsOnPages.clickWriteMessageButton();
	writeLetterPage.fillToField(receiver);
	writeLetterPage.clickByMessageField();
	writeLetterPage.fillSubjectField(subject);
	writeLetterPage.fillMessageField(message);
    }

    public void saveLetterAsDraft() {
	writeLetterPage.save();
    }

    public void refresh() {
	inboxPage.linksToMainPages.clickInboxLink();
	inboxPage.waitTitle();
	inboxPage.overallButtonsOnPages.refreshButton();
	inboxPage.linksToMainPages.clickDraftLink();
	draftPage.waitTitle();

    }

}
