package mail.tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mail.using.ReadFromXML;

public class TransferDraft extends BasicTestClass {

    @BeforeClass
    public void setLogin() {
	login.log();
	 drafts.deleteDrafts();
    }

    @Test(dependsOnGroups = "login", dataProvider = "letterData", priority = 4)
    public void trancferDrafts(String receiver, String subject, String message) {

	createDraft.fillFields(receiver, subject, message);
	createDraft.save();

	linksToMainPages.toDraftLinkClick();
	draftPage.waitTitle();
	commonButtons.refreshButton();

	waitpageload();
	draftPage.dropLetter();

	assertTrue(getDraftPage().noLetters());
	linksToMainPages.ToInboxClick();
	inboxPage.waitTitle();

    }

    @DataProvider
    private Object[][] letterData() {
	return ReadFromXML.getData(FILE_NAME);
    }
}
