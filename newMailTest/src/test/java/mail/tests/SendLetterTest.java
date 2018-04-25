package mail.tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import mail.pages.main.SentMessagesPage;
import mail.tests.common.GeneralActions;

public class SendLetterTest extends GeneralActions {

    private SentMessagesPage sentMessagesPage;  

    @Test(groups = { "other-functions" }, dataProvider = "FillLetter", priority = 3)
    public void sendLetter(String receiver, String subject, String message) {
	fillFields(receiver, subject, message);
	sentMessagesPage = writeLetterPage.clickSubmitButton();
	sentMessagesPage.waitSent();
	sentMessagesPage.closeInfomWindow();
	refresh();
	draftPage.linksToMainPages.clickSentLink();
	sentMessagesPage.waitTitle();
	assertTrue(message.contains(sentMessagesPage.getFirstSendedMessage()));
    }  

    @AfterMethod
    public void deleteSendedMessage() {
	sentMessagesPage.linksToMainPages.clickSentLink();
	sentMessagesPage.waitTitle();
	sentMessagesPage.selectAllDrafts();
	sentMessagesPage.overallButtonsOnPages.clickDeleteButton();
    }

    @DataProvider(name = "FillLetter")
    private Object[][] dataToFillLetter() {
	return mail.using.ReadFromXML.getData(FILE_NAME);
    }
}
