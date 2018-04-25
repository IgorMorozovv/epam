package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mail.pages.write.LetterFieldsAssert;
import mail.tests.common.GeneralActions;

public class VerifyDraftsTests extends GeneralActions {

    private LetterFieldsAssert letterFieldsAssert;

    @BeforeClass
    public void setUp() {
	letterFieldsAssert = new LetterFieldsAssert(driver);
    }

    @AfterClass
    public void deleteDrafts() {
	deleteAllDrafts();
    }

    @Test(groups = { "other-functions" }, dataProvider = "FillLetter", priority = 2)
    private void verifyDraft(String receiver, String subject, String message) {
	fillFields(receiver, subject, message);
	saveLetterAsDraft();
	refresh();
	draftPage.linksToMainPages.clickDraftLink();
	draftPage.waitTitle();
	draftPage.clickFirstDraft();
	assertTrue(letterFieldsAssert.assertReceiver(receiver));
	assertTrue(letterFieldsAssert.assertSubject(subject));
	assertTrue(letterFieldsAssert.assertMessage(message));

	inboxPage.linksToMainPages.clickInboxLink();
	inboxPage.waitTitle();
    }

    @DataProvider(name = "FillLetter")
    private Object[][] dataToFillLetter() {
	return mail.using.ReadFromXML.getData(FILE_NAME);
    }

}
