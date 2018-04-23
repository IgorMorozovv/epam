package mail.pages.main;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SentMessagesPage extends Page {

    String TITLE = "Отправленные";

    public SentMessagesPage(WebDriver driver) {

	super(driver);
	PageFactory.initElements(driver, this);
	title = TITLE;
    }

    @FindBy(xpath = "//*[contains(@class,'js-message-snippet-firstline')]/span")
    List<WebElement> messages;

    @FindBy(xpath = "//*[contains(@class,'checkbox-normal-flag')]")
    List<WebElement> checkBoxMessages;

    @FindBy(xpath = "//*[@class='checkbox_view']")
    private List<WebElement> checkAllLetters;

    @FindBy(xpath = "//*[contains(text(), 'отправлено')]")
    WebElement sentMessage;

    @FindBy(xpath = "//*[contains(@class,'mail-Notification-Close')]")
    WebElement closeInfomWindow;

    public void closeInfomWindow() {
	waitVisibleElement(closeInfomWindow);
	new Actions(driver).click(closeInfomWindow).build().perform();
    }

    public String getFirstSendedMessage() {

	String firstMessage;
	try {
	    firstMessage = messages.get(firstDraftIndex).getAttribute("title");
	} catch (IndexOutOfBoundsException e) {
	    e.printStackTrace();
	    firstMessage = null;
	}

	return firstMessage;
    }

    public void checkFirstMessage() {
	new Actions(driver).click(checkBoxMessages.get(firstDraftIndex)).build().perform();

    }

    public void waitSent() {
	waitVisibleElement(sentMessage);

    }

    public void waitLoad() {
	(new WebDriverWait(driver, waitTime)).until(ExpectedConditions.titleContains(title));

    }

    public void selectAllDrafts() {

	new Actions(driver).click(checkAllLetters.get(firstDraftIndex)).build().perform();
    }
}
