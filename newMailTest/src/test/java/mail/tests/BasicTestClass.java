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

import mail.pages.YandexMainPage;
import mail.pages.main.DraftPage;
import mail.pages.main.InboxPage;
import mail.pages.main.SentMessagesPage;
import mail.pages.overall.LinksToMainPages;
import mail.pages.overall.OverallButtonsOnPages;
import mail.pages.write.LetterFieldsAssert;
import mail.pages.write.WriteLetterPage;
import mail.using.CreateDraft;
import mail.using.Drafts;
import mail.using.Login;

public class BasicTestClass {

    protected Login login;
    protected OverallButtonsOnPages commonButtons;
    protected DraftPage draftPage;
    protected CreateDraft createDraft;
    protected WriteLetterPage writeLetterPage;
    protected YandexMainPage yandexMainPage;
    protected LetterFieldsAssert letterFieldsAssert;
    protected SentMessagesPage sentMessagesPage;
    protected LinksToMainPages linksToMainPages;
    protected InboxPage inboxPage;
    protected Drafts drafts;
    protected WebDriver driver;

    // TODO: константы выносятся в начало класса, не забывай про порядок
    // модификаторов доступа
    protected static final String FILE_NAME = "forDraft.xml";
    static final String URL = "http://localhost:4441/wd/hub/";
    static final private String START_BY_HUB = "hub";
    static final private String START_BY_DRIVER = "driver";
    static final int WAIT_TIME = 10;

    public BasicTestClass() {

	setPages();

    }

    private void setPages() {

	inboxPage = new InboxPage(driver);
	commonButtons = new OverallButtonsOnPages(driver);
	draftPage = new DraftPage(driver);
	writeLetterPage = new WriteLetterPage(driver);
	yandexMainPage = new YandexMainPage(driver);
	letterFieldsAssert = new LetterFieldsAssert(driver);
	sentMessagesPage = new SentMessagesPage(driver);
	linksToMainPages = new LinksToMainPages(driver);

	drafts = new Drafts(this);
	login = new Login(driver);
	createDraft = new CreateDraft(this);

    }

    @Parameters({ "start" })
    @BeforeClass
    public void beforeClass(@Optional(START_BY_DRIVER) String start) throws MalformedURLException {

	switch (start) {
	case START_BY_HUB:

	    DesiredCapabilities capability = DesiredCapabilities.firefox();
	    driver = new RemoteWebDriver(new URL(URL), capability);
	    break;

	case START_BY_DRIVER:
	    driver = new FirefoxDriver();

	default:
	    break;
	}

	driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
	setPages();

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
	driver.quit();
    }

    public LinksToMainPages getLinksToMainPages() {
	return linksToMainPages;
    }

    public DraftPage getDraftPage() {
	return draftPage;
    }

    public OverallButtonsOnPages getCommonButtons() {
	return commonButtons;
    }

    public WriteLetterPage getWriteLetterPage() {

	return writeLetterPage;
    }

    public InboxPage getInboxPage() {

	return inboxPage;
    }

}
