package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SendLetterTest extends BasicTestClass {

    @BeforeClass
    public void setLogin() {
	login.log();	
    }

    @Test(dependsOnGroups = "login", dataProvider = "FillLetter", priority = 3)
    public void sendLetter(String receiver, String subject, String message) {

	waitpageload();

	commonButtons.clickWriteMessageButton();

	createDraft.fillFields(receiver, subject, message);

	writeLetterPage.clickSubmitButton();

	sentMessagesPage.waitSent();
	sentMessagesPage.closeInfomWindow();

	commonButtons.refreshButton();

	linksToMainPages.toSentMessageClick();
	sentMessagesPage.waitTitle();
	commonButtons.refreshButton();

	String string = sentMessagesPage.getFirstSendedMessage();
	assertTrue(message.contains(string));

	
    }

    @AfterMethod
    public void deleteSendedMessage() {
	

	linksToMainPages.toSentMessageClick();
	sentMessagesPage.waitTitle();
	sentMessagesPage.selectAllDrafts();
	commonButtons.clickDeleteButton();
    }

    @DataProvider(name = "FillLetter")
    private Object[][] dataToFillLetter() {

	return mail.using.ReadFromXML.getData(FILE_NAME);
    }
}
