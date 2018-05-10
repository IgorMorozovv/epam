package mail.pom.tests.cases;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mail.logging.LoggingMessages;
import mail.pom.pages.main.SentMessagesPage;
import mail.pom.tests.common.GeneralActions;

public class SendLetterTest extends GeneralActions {

    private SentMessagesPage sentMessagesPage;

    @Test(groups = { "other-functions" }, dataProvider = "FillLetter", priority = 3)
    public void sendLetter(String receiver, String subject, String message) {	
	fillFields(receiver, subject, message);
	logger.info(LoggingMessages.SENDING_MESSAGE);
	sentMessagesPage = writeLetterPage.clickSubmitButton();
	logger.info(LoggingMessages.WAIT_AND_CLOSE_SENT_MESSAGE);
	sentMessagesPage.waitSent().closeInformWindow();
	refresh();
	draftPage.linksToMainPages.clickSentLink().waitTitle();
	assertTrue(message.contains(sentMessagesPage.getFirstSendedMessage()));
    }

    @AfterMethod
    public void deleteSendedMessage() {
	logger.info(LoggingMessages.DELETE_SENT_LETTERS_MESSAGE);
	sentMessagesPage.linksToMainPages.clickSentLink();
	sentMessagesPage.waitTitle();
	sentMessagesPage.selectAllDrafts();
	sentMessagesPage.overallButtonsOnPages.clickDeleteButton();
    }

    @DataProvider(name = "FillLetter")
    private Object[][] dataToFillLetter() {
	return dataReader.getData(FILE_NAME);
    }

}
