package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifyDraftsTests extends BasicTestClass {

    @BeforeClass()
    public void setUp() {
	login.log();

    }

    @AfterClass
    public void deleteDrafts() {

	drafts.deleteDrafts();

    }

    @Test(groups = { "other-functions" }, dataProvider = "FillLetter", priority = 2)
    private void verifyDraft(String receiver, String subject, String message) {

	drafts.fillFields(receiver, subject, message);
	drafts.save();

	drafts.refresh();	
	
	linksToMainPages.toDraftLinkClick();
	draftPage.waitTitle();
	
	draftPage.loadLastDraft();

	assertTrue(letterFieldsAssert.assertReceiver(receiver));
	assertTrue(letterFieldsAssert.assertSubject(subject));
	assertTrue(letterFieldsAssert.assertMessage(message));

	linksToMainPages.ToInboxClick();
	inboxPage.waitTitle();
    }



    @DataProvider(name = "FillLetter")
    private Object[][] dataToFillLetter() {

	return mail.using.ReadFromXML.getData(FILE_NAME);
    }

}
