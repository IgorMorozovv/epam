package mail.pom.tests.cases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import mail.buisnes.GeneralActions;
import mail.data.EmailDataProvider;
import mail.logging.LoggingMessages;
import mail.pom.pages.main.SentMessagesPage;

public class SendLetterTest extends GeneralActions {

    private SentMessagesPage sentMessagesPage;

    @Test(groups = {
	    "other-functions" }, dataProvider = "data", dataProviderClass = EmailDataProvider.class, priority = 3)
    public void sendLetter(String receiver, String subject, String message) {
	inboxPage = loginLogout.logIn();
	fillFields(receiver, subject, message);

	logger.info(LoggingMessages.SENDING_MESSAGE);
	sentMessagesPage = writeLetterPage.clickSubmitButton();

	logger.info(LoggingMessages.ASSERT_SEND_LETTER_MESSAGE);
	assertTrue(sentMessagesPage.isSentMessageDisplay(), LoggingMessages.FAILURE_VERIFY_SEND_LETTER_MESSAGE);

	sentMessagesPage.closeInformWindow();
	loginLogout.logout();
    }

    public void deleteSendedMessage() {
	logger.info(LoggingMessages.DELETE_SENT_LETTERS_MESSAGE);
	sentMessagesPage.linksToMainPages.clickSentLink();
	sentMessagesPage.waitTitle();
	sentMessagesPage.selectAllDrafts();
	sentMessagesPage.overallButtonsOnPages.clickDeleteButton();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
	deleteSendedMessage();
	logger.info(LoggingMessages.END_TEST_MESSAGE + getClass().getName());
	driver.close();
    }
}
