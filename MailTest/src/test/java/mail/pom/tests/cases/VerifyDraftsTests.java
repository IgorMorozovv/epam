package mail.pom.tests.cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mail.logging.LoggingMessages;
import mail.pom.pages.write.LetterFieldsAssert;
import mail.pom.tests.common.GeneralActions;

public class VerifyDraftsTests extends GeneralActions {

    private LetterFieldsAssert letterFieldsAssert;

    @BeforeClass
    public void setUp() {
	// logger = Logger.getLogger(VerifyDraftsTests.class);
	deleteAllDrafts();
    }

    @Test(groups = { "other-functions" }, dataProvider = "FillLetter", priority = 2)
    private void verifyDraft(String receiver, String subject, String message) {
	fillFields(receiver, subject, message);
	saveLetterAsDraft();
	refresh();
	logger.info(LoggingMessages.TO_FIRST_DRAFT_MESSAGE);
	draftPage = inboxPage.linksToMainPages.clickDraftLink();
	draftPage.waitTitle();
	letterFieldsAssert = draftPage.clickFirstDraft();

	logger.info(LoggingMessages.ASSERT_FILL_FIELDS);
	try {
	    assertEquals(receiver, letterFieldsAssert.getReceiver(), "Значения не совпадают");
	    assertEquals(subject, letterFieldsAssert.getSubject(), "Значения не совпадают");
	    assertEquals(message, letterFieldsAssert.getMessage(), "значения не совпадают");
	} catch (AssertionError | MoveTargetOutOfBoundsException e) {
	    logger.error(e.getMessage());
	    fail(e.getMessage());
	}
	draftPage.linksToMainPages.clickInboxLink().waitTitle();

    }

    @AfterClass
    public void deleteDrafts() {
	deleteAllDrafts();
    }

    @DataProvider(name = "FillLetter")
    private Object[][] dataToFillLetter() {
	return dataReader.getData(FILE_NAME);
    }

}
