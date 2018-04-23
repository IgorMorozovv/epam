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

    }

    @Test(groups = { "other-functions" }, dataProvider = "letterData", priority = 4)
    public void trancferDrafts(String receiver, String subject, String message) {

	drafts.fillFields(receiver, subject, message);
	drafts.save();

	drafts.refresh();	
	
	linksToMainPages.toDraftLinkClick();
	draftPage.waitTitle();	
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
