package mail.pom.tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.uncommons.reportng.HTMLReporter;

import mail.configuration.ReadConfiguration;
import mail.logging.LoggingMessages;
import mail.pom.pages.LoginPage;
import mail.pom.pages.main.DraftPage;
import mail.pom.pages.main.InboxPage;
import mail.pom.pages.write.WriteLetterPage;
import mail.utility.driver.ConcreteDriver;

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
    private ConcreteDriver concreteDriver = new ConcreteDriver();

    @BeforeClass
    public void basicTestClass() throws MalformedURLException {
	setDriver();
	driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
	logIn();
    }

    private void setDriver() throws MalformedURLException {
	if (driver == null) {
	    driver = concreteDriver.getDriver();
	}
    }

    private void logIn() {
	loginPage = new LoginPage(driver);

	logger.info(LoggingMessages.ENTER_PAGE_MESSAGE);
	loginPage.fillAccountData();

	logger.info(LoggingMessages.ENTER_BUTTON_CLICK_MESSAGE);
	inboxPage = loginPage.clickEnter();
	inboxPage.waitTitle();
    }
}
