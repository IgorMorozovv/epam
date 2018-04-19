package mail.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
    protected static final String FILE_NAME = "forDraft.xml";
    static final String URL = "http://localhost:4441/wd/hub/";
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
    public void beforeClass(@Optional("2") String start) throws MalformedURLException {

	switch (start) {
	case "1":	    
	   
	    DesiredCapabilities capability = DesiredCapabilities.firefox();
	    driver = new RemoteWebDriver(new URL(URL), capability);
	    break;
	    
	case "2":
	    driver = new FirefoxDriver();
	    
	default:
	    break;
	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	setPages();

    }

    public void waitpageload() {
	WebDriverWait wait = new WebDriverWait(driver, 15);

	wait.until(new ExpectedCondition<Boolean>() {
	    public Boolean apply(WebDriver wdriver) {
		return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	    }
	});

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
	driver.quit();
    }

    @DataProvider(name = "FillLetter")
    private Object[][] dataToFillLetter() {

	return mail.using.ReadFromXML.getData(FILE_NAME);
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
   
}
