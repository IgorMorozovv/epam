package mail.pom.pages.main;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SentMessagesPage extends BasePageFolder {

    private static final String TITLE = "Отправленные";
    private static final String CLOSE_INFORM_BUTTON_MESSAGE = " кнопка закрытия окна Отправлено";
    private static final String SENT_FORM_MESSAGE = " текст Отправлено";

    @FindBy(xpath = "//*[contains(@class,'js-message-snippet-firstline')]/span")
    private List<WebElement> messages;

    @FindBy(xpath = "//*[@class='checkbox_view']")
    private List<WebElement> checkAllLetters;

    @FindBy(xpath = "//*[contains(text(), 'отправлено')]")
    WebElement sentMessage;

    @FindBy(xpath = "//*[contains(@class,'mail-Notification-Close')]")
    WebElement closeInfomWindow;

    public SentMessagesPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	title = TITLE;
    }

    public void closeInformWindow() {
	waitVisibleElement(closeInfomWindow, CLOSE_INFORM_BUTTON_MESSAGE);
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

    public boolean isSentMessageDisplay() {
	waitVisibleElement(sentMessage, SENT_FORM_MESSAGE);
	return true;
    }

    public void selectAllDrafts() {
	new Actions(driver).click(checkAllLetters.get(firstDraftIndex)).build().perform();
    }

}
