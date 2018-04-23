package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mail.using.ReadFromXML;

public class CreateDraftTest extends BasicTestClass {

    @BeforeClass
    public void setLogin() {
	login.log();
	inboxPage.waitTitle();
    }

    @Test(groups = "basic-functions", dataProvider = "letterData", priority = 1)
    public void createMessage(String receiver, String subject, String message) {

	drafts.fillFields(receiver, subject, message);
	drafts.save();
	assertTrue(writeLetterPage.SavedTextVisible());
	linksToMainPages.ToInboxClick();
	inboxPage.waitTitle();
    }

    @AfterClass
    private void deleteDrafts() {

	drafts.deleteDrafts();
    }

    @DataProvider
    private Object[][] letterData() {
	return ReadFromXML.getData(FILE_NAME);
    }
}
