package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import mail.using.ReadFromXML;

public class CreateDraftTest extends BasicTestClass {

    private static String FILE_NAME = "forDraft.xml";

    @BeforeClass
    public void setLogin() {
	login.log();
	inboxPage.waitTitle();
    }

    @Test(dependsOnGroups = "login", dataProvider = "letterData", priority = 0)
    public void createMessage(String receiver, String subject, String message) {

	
	createDraft.fillFields(receiver, subject, message);
	createDraft.save();
	assertTrue(writeLetterPage.SavedTextVisible());

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
