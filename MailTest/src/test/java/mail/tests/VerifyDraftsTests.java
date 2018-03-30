package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mail.data.ReadFromXML;

public class VerifyDraftsTests extends Basic {

    private Object[][] dataToLetters;

    @BeforeMethod()
    public void setUp() {

	dataToLetters = ReadFromXML.getData(FILE_NAME);
    }

    @AfterMethod
    public void deleteDrafts() {
	mailPage.clickDraftLink();
	draftPage.selectLastDraft();
	mailPage.clickDeleteButton();

    }

    @Test(dependsOnGroups = "createDraft", dataProvider = "dataToFillLetter", priority = 1)
    private void verifyDraft(String receiver, String subject, String message) {
	mailPage.clickDraftLink();
	draftPage.loadLastDraft();
	assertTrue(composeLetterPage.assertReceiver(receiver));
	assertTrue(composeLetterPage.assertSubject(subject));
	assertTrue(composeLetterPage.assertMessage(message));
    }

    @DataProvider
    private Object[][] dataToFillLetter() {

	dataToLetters = ReadFromXML.getData(FILE_NAME);
	return dataToLetters;
    }

}
