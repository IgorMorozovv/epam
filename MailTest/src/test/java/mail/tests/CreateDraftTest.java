package mail.tests;

import static org.testng.Assert.assertTrue;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import mail.data.ReadFromXML;

public class CreateDraftTest extends Basic {

    Object[][] dataToLetters;

    final static String FILE_NAME = "forDraft.xml";

    @Test(groups = "createDraft", dependsOnGroups = "login", dataProvider = "dataToFillLetter", priority = 0)
    public void createDraft(String to, String subject, String message) {

	mailPage.clickWriteMessageButton();
	composeLetterPage.fillToField(to);
	composeLetterPage.fillSubjectField(subject);
	composeLetterPage.fillMessageField(message);

	assertTrue(composeLetterPage.draftFormIsDisplayed());
	
	composeLetterPage.clickSaveButton();
	 assertTrue(mailPage.draftSaved());
    }



    @DataProvider
    private Object[][] dataToFillLetter() {

	dataToLetters = ReadFromXML.getData(FILE_NAME);
	return dataToLetters;
    }
}