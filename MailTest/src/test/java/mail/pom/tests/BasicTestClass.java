package mail.pom.tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.uncommons.reportng.HTMLReporter;

import mail.configuration.ReadConfiguration;
import mail.logging.LoggingMessages;
import mail.pom.pages.LoginPage;
import mail.pom.pages.main.DraftPage;
import mail.pom.pages.main.InboxPage;
import mail.pom.pages.write.WriteLetterPage;
import mail.utility.driver.Driver;

@Listeners({ HTMLReporter.class })
public class BasicTestClass {

    protected static final String FILE_NAME = ReadConfiguration.getPathToData();
    private static final int WAIT_TIME = 10;

    protected WebDriver driver;
    protected InboxPage inboxPage;
    protected DraftPage draftPage;
    protected WriteLetterPage writeLetterPage;
    protected LoginPage loginPage;
    protected Logger logger = Logger.getLogger(getClass());
    private Driver getDriver = new Driver();

    @BeforeClass

    public void beforeClass() throws MalformedURLException {
	driver = getDriver.getDriver();
	driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
	logIn();
    }

    private void logIn() {
	loginPage = new LoginPage(driver);

	logger.info(LoggingMessages.ENTER_PAGE_MESSAGE);
	loginPage.fillAccountData();

	logger.info(LoggingMessages.ENTER_BUTTON_CLICK_MESSAGE);
	inboxPage = loginPage.clickEnter();
	inboxPage.waitTitle();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
	logger.info(LoggingMessages.END_TEST_MESSAGE + getClass().getName());
	if (driver != null) {
	    driver.quit();
	}
    }
}
