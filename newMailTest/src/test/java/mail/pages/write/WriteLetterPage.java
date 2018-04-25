package mail.pages.write;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mail.pages.BasicPage;
import mail.pages.main.SentMessagesPage;

public class WriteLetterPage extends BasicPage {

    @FindBy(xpath = "//*[@type = 'submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@data-action='save']")
    private WebElement saveButton;

    @FindBy(name = "to")
    private WebElement receiverField;

    @FindBy(name = "subj")
    private WebElement subjectField;

    @FindBy(xpath = "//*[@role = 'textbox']")
    private WebElement messageField;

    @FindBy(xpath = "//*[contains(text(), 'как черновик')]")
    private WebElement textBySaved;

    public WriteLetterPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
    }

    public void fillToField(String receiver) {
	waitVisibleElement(receiverField);
	new Actions(driver).sendKeys(receiverField, receiver).sendKeys(Keys.ENTER).build().perform();

    }

    public void fillSubjectField(String subject) {
	waitVisibleElement(subjectField);
	new Actions(driver).sendKeys(subjectField, subject).build().perform();

    }

    public void fillMessageField(String message) {

	new Actions(driver).click(messageField).sendKeys(messageField, message).build().perform();

    }

    public SentMessagesPage clickSubmitButton() {
	new Actions(driver).click(submitButton).build().perform();
	return new SentMessagesPage(driver);
    }

    public void saveLetterAsDraft() {
	new Actions(driver).keyDown(Keys.CONTROL).sendKeys("S").keyUp(Keys.CONTROL).build().perform();
	waitVisibleElement(textBySaved);
    }

    public WebElement getSavedTextArea() {
	return textBySaved;
    }

    public void clickByMessageField() {
	new Actions(driver).click(messageField).build().perform();

    }
    
}
