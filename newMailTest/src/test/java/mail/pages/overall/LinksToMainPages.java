package mail.pages.overall;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import mail.pages.BasicPage;

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

    public void clickDraftLink() {
	click(toDraftPage);
    }

    public void clickSentLink() {

	click(toSentMessages);
    }

    public void clickInboxLink() {
	click(toInBox);
    }

    public WebElement getDeleteLink() {
	return driver.findElement(toDelete);
    }

}
