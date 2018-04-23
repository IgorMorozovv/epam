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

    @Test(groups = { "other-functions" }, dataProvider = "FillLetter", priority = 3)
    public void sendLetter(String receiver, String subject, String message) {

	drafts.fillFields(receiver, subject, message);
	writeLetterPage.clickSubmitButton();

	sentMessagesPage.waitSent();
	sentMessagesPage.closeInfomWindow();

	drafts.refresh();

	linksToMainPages.toSentMessageClick();
	sentMessagesPage.waitTitle();

	assertTrue(message.contains(sentMessagesPage.getFirstSendedMessage()));

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
