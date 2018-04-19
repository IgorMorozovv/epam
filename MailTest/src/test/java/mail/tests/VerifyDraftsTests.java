package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifyDraftsTests extends BasicTestClass {

    private static final String FILE_NAME = "forDraft.xml";

    @BeforeClass()
    public void setUp() {
	login.log();

    }

    @AfterMethod
    public void deleteDrafts() throws InterruptedException {

	drafts.deleteDrafts();

    }

    @Test(dependsOnGroups = "login", dataProvider = "FillLetter", priority = 1)
    private void verifyDraft(String receiver, String subject, String message) {

	createDraft.fillFields(receiver, subject, message);
	writeLetterPage.save();

	linksToMainPages.toDraftLinkClick();
	draftPage.waitTitle();
	commonButtons.refreshButton();
	waitpageload();
	draftPage.loadLastDraft();
	assertTrue(letterFieldsAssert.assertReceiver(receiver));
	assertTrue(letterFieldsAssert.assertSubject(subject));
	assertTrue(letterFieldsAssert.assertMessage(message));

    }

    @DataProvider(name = "FillLetter")
    private Object[][] dataToFillLetter() {

	return mail.using.ReadFromXML.getData(FILE_NAME);
    }

}
