package mail.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import mail.pages.LoginPage;
import mail.pages.main.DraftPage;
import mail.pages.main.InboxPage;
import mail.pages.write.WriteLetterPage;

public class BasicTestClass {

    protected static final String FILE_NAME = "forDraft.xml";
    private static final String URL = "http://localhost:4441/wd/hub/";
    private static final String START_BY_HUB = "hub";
    private static final String START_BY_DRIVER = "driver";
    private static final int WAIT_TIME = 10;

    protected WebDriver driver;
    protected InboxPage inboxPage;
    protected DraftPage draftPage;
    protected WriteLetterPage writeLetterPage;
    protected LoginPage loginPage;

    @Parameters({ "start" })
    @BeforeClass
    public void beforeClass(@Optional(START_BY_DRIVER) String start) throws MalformedURLException {

	switch (start) {
	case START_BY_HUB:
	    DesiredCapabilities capability = DesiredCapabilities.firefox();
	    driver = new RemoteWebDriver(new URL(URL), capability);
	    break;
	case START_BY_DRIVER:
	    System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
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
	loginPage.fillAccountData();
	inboxPage = loginPage.clickEnter();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {

	if (driver != null) {
	    driver.quit();
	}
    }
    
}
