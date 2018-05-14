package mail.pom.pages.overall;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import mail.pom.pages.BasicPage;
import mail.pom.pages.main.DraftPage;
import mail.pom.pages.main.InboxPage;
import mail.pom.pages.main.SentMessagesPage;

/*
 * Страница с сылками на папки: входящие, удаленные, отправленные и черновики
 */
public class LinksToMainPages extends BasicPage {

    private final static int SLEEP_TIME = 500;
    private final static int MAX_TIMER = 5000;

    private By toDraftPage = new By.ByXPath("//*[text() = 'Черновики']");
    private By toSentMessages = new By.ByXPath("//*[text() = 'Отправленные']");
    private By toInBox = new By.ByXPath("//*[text() = 'Входящие']");
    private By toDelete = new By.ByXPath("//*[text() = 'Удалённые']");

    public LinksToMainPages(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
    }

    private void click(By locator) {
	boolean isNotFind = true;
	int timer = 0;
	WebElement element;

	while (isNotFind && timer <= MAX_TIMER) {
	    try {
		Thread.sleep(SLEEP_TIME);
		element = driver.findElement(locator);
		element.click();
		isNotFind = false;
	    } catch (StaleElementReferenceException | InterruptedException e) {
		// TODO: то же самое, что и в BasePageFolder
		e.printStackTrace();
		timer += SLEEP_TIME;
		logger.error(e.getMessage());
	    }
	}
    }

    public DraftPage clickDraftLink() {
	click(toDraftPage);
	return new DraftPage(driver);
    }

    public SentMessagesPage clickSentLink() {
	click(toSentMessages);
	return new SentMessagesPage(driver);
    }

    public InboxPage clickInboxLink() {
	click(toInBox);
	return new InboxPage(driver);
    }

    public WebElement getDeleteLink() {
	return driver.findElement(toDelete);
    }

}
