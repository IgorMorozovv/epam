package mail.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.uncommons.reportng.HTMLReporter;

import mail.pages.LoginPage;
import mail.pages.main.DraftPage;
import mail.pages.main.InboxPage;
import mail.pages.write.WriteLetterPage;
import mail.utility.Read;
import mail.utility.ReadFromCsv;

@Listeners({ HTMLReporter.class })
public class BasicTestClass {

    protected static final String FILE_NAME = "forDraft.xml";
    private static final String URL = "http://10.19.10.150:4444/wd/hub";
    private static final String START_BY_HUB = "hub";
    private static final String START_BY_DRIVER = "driver";
    private static final int WAIT_TIME = 10;

    protected WebDriver driver;
    protected InboxPage inboxPage;
    protected DraftPage draftPage;
    protected WriteLetterPage writeLetterPage;
    protected LoginPage loginPage;

    protected Logger logger = Logger.getLogger(BasicTestClass.class);

    protected Read dataReader = new ReadFromCsv();

    @Parameters({ "start" })

    @BeforeClass

    public void beforeClass(@Optional(START_BY_DRIVER) String start) throws MalformedURLException {
	// System.setProperty("org.uncommons.reportng.escape-output", "false");
	switch (start) {
	case START_BY_HUB:
	    // DesiredCapabilities capability = DesiredCapabilities.firefox();
	    driver = new RemoteWebDriver(new URL(URL), DesiredCapabilities.chrome());
	    break;
	case START_BY_DRIVER:
	    System.setProperty("webdriver.gecko.driver", "configuration//geckodriver.exe");
	    driver = new FirefoxDriver();
	    break;
	default:
	    break;
	}

	driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
	logIn();
    }

    private void logIn() {
	loginPage = new LoginPage(driver);
	logger.info("Страница входа, заполнение полей");
	loginPage.fillAccountData();
	logger.info("Нажатие кнопки вход");
	inboxPage = loginPage.clickEnter();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
	if (driver != null) {
	    driver.quit();
	}
    }

}
