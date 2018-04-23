package mail.pages.overall;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinksToMainPages extends OverallButtonsOnPages {

    private final static int ATTEMPTS = 2;
    private final static int SLEEP_TIME = 100;
    private final static int WAIT_TIME = 10;

    /*
     * Страница с сылками на папки: входящие, удаленные, отправленные и черновики
     */
    public LinksToMainPages(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);

    }

    private By toDraftPage = new By.ByXPath("//*[text() = 'Черновики']");
    private By toSentMessages = new By.ByXPath("//*[text() = 'Отправленные']");
    private By toInBox = new By.ByXPath("//*[text() = 'Входящие']");
    private By toDelete = new By.ByXPath("//*[text() = 'Удалённые']");

    public void waitVisibleElement(WebElement element) {

	try {
	    new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
	} catch (ElementNotVisibleException e) {
	    e.printStackTrace();
	} catch (TimeoutException e) {
	    e.printStackTrace();
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    private void click(By locator) {
	for (int i = 0; i < ATTEMPTS; i++) {
	    try {
		WebElement element = driver.findElement(locator);
		element.click();
		Thread.sleep(SLEEP_TIME);
	    } catch (StaleElementReferenceException e) {
		e.printStackTrace();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

    public void toDraftLinkClick() {

	click(toDraftPage);

    }

    public void toSentMessageClick() {

	click(toSentMessages);
    }

    public void ToInboxClick() {
	click(toInBox);
    }

    public WebElement getToDelete() {
	return driver.findElement(toDelete);
    }

}
