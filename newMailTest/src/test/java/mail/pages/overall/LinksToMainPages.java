package mail.pages.overall;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import mail.pages.BasicPage;
import mail.pages.main.DraftPage;
import mail.pages.main.InboxPage;
import mail.pages.main.SentMessagesPage;

/*
 * Страница с сылками на папки: входящие, удаленные, отправленные и черновики
 */
public class LinksToMainPages extends BasicPage {

    private final static int SLEEP_TIME = 100;

    private By toDraftPage = new By.ByXPath("//*[text() = 'Черновики']");
    private By toSentMessages = new By.ByXPath("//*[text() = 'Отправленные']");
    private By toInBox = new By.ByXPath("//*[text() = 'Входящие']");
    private By toDelete = new By.ByXPath("//*[text() = 'Удалённые']");

    public LinksToMainPages(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
    }

    private void click(By locator) {

	for (int i = 0; i < ATTEMPTS; i++) {

	    try {
		WebElement element = driver.findElement(locator);
		element.click();
		Thread.sleep(SLEEP_TIME);
	    } catch (StaleElementReferenceException | InterruptedException e) {
		e.printStackTrace();
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
