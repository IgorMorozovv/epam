package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mail.pages.write.WriteLetterPage;
import mail.tests.common.GeneralActions;
import mail.using.ReadFromXML;

public class CreateDraftTest extends GeneralActions {

    @Test(groups = "basic-functions", dataProvider = "letterData", priority = 1)
    public void createMessage(String receiver, String subject, String message) {
	inboxPage.waitTitle();
	fillFields(receiver, subject, message);
	saveLetterAsDraft();
	assertTrue(writeLetterPage.getSavedTextArea().isDisplayed(), "Verify that saved text is displayed");
	inboxPage.linksToMainPages.clickInboxLink();
	inboxPage.waitTitle();
    }

    @AfterClass
    private void deleteDrafts() {
	deleteAllDrafts();
    }

    @DataProvider
    private Object[][] letterData() {
	return ReadFromXML.getData(FILE_NAME);
    }
    
}
