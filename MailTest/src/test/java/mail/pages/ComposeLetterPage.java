package mail.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeLetterPage {

    public ComposeLetterPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver = driver;
    }

    public WebDriver driver;

    By mainForm = new ById("main");

    @FindBy(xpath = "//*[@class = 'b-form']")
    protected WebElement draftForm;
    
    @FindBy(name = "to")
    protected WebElement receiverField;

    @FindBy(name = "subj")
    protected WebElement subjectField;

    @FindBy(name = "send")
    protected WebElement messageField;

    @FindBy(name = "doit")
    protected WebElement sendButton;

    @FindBy(xpath = "//*[@value = 'Сохранить']")
    protected WebElement saveButton;
    
    public boolean draftFormIsDisplayed() {
	return draftForm.isDisplayed();
    }

    public void fillToField(String receiver) {
	receiverField.sendKeys(receiver);
    }

    public void fillSubjectField(String receiver) {
	subjectField.sendKeys(receiver);
    }

    public void fillMessageField(String receiver) {
	messageField.sendKeys(receiver);
    }

    public void clickSendButton() {
	sendButton.click();
    }

    public void clickSaveButton() {
	saveButton.click();
    }

    public boolean assertReceiver(String receiver) {
	return (receiverField.getAttribute("value").contains(receiver));
    }

    public boolean assertSubject(String subject) {
	return (subjectField.getAttribute("value").contains(subject));
    }

    public boolean assertMessage(String message) {
	return (messageField.getAttribute("value").contains(message));
    }

    public boolean assertOpenForm() {
	return (driver.findElement(mainForm).isDisplayed());

    }

}
