package mail.using;

import org.openqa.selenium.StaleElementReferenceException;

import mail.tests.BasicTestClass;

public class Drafts {

    BasicTestClass basicTestClass;

    public Drafts(BasicTestClass basicTestClass) {
	this.basicTestClass = basicTestClass;
    }

    public void deleteDrafts() {

	refresh();
	try {
	    basicTestClass.getLinksToMainPages().toDraftLinkClick();
	    basicTestClass.getDraftPage().waitTitle();
	    basicTestClass.getCommonButtons().refreshButton();
	    basicTestClass.getDraftPage().waitLetters();
	    basicTestClass.getDraftPage().selectAllDrafts();
	    basicTestClass.getCommonButtons().clickDeleteButton();
	} catch (StaleElementReferenceException e) {

	}

    }

    public void fillFields(String receiver, String subject, String message) {

	basicTestClass.getCommonButtons().clickWriteMessageButton();

	basicTestClass.getWriteLetterPage().fillToField(receiver);

	basicTestClass.getWriteLetterPage().clickByMessageField();

	basicTestClass.getWriteLetterPage().fillSubjectField(subject);

	basicTestClass.getWriteLetterPage().fillMessageField(message);

    }

    public void save() {
	basicTestClass.getWriteLetterPage().save();
    }

    public void refresh() {
	basicTestClass.getLinksToMainPages().ToInboxClick();
	basicTestClass.getInboxPage().waitTitle();
	
	basicTestClass.getCommonButtons().refreshButton();
	
	basicTestClass.getLinksToMainPages().toDraftLinkClick();
	basicTestClass.getDraftPage().waitTitle();

    }

}
