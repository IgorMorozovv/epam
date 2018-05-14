package mail.pom.pages.write;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mail.pom.pages.BasicPage;

public class LetterFieldsAssert extends BasicPage {

    private static final String DATA_EMAIL = "data-yabble-email";

    private static final String RECEIVER_FIELD_MESSAGE = " поле получателя";

    @FindBy(xpath = "//*[@name='to']/span")
    private WebElement receiverFieldAssert;

    @FindBy(name = "subj")
    private WebElement subjectField;

    @FindBy(xpath = "//*[@role = 'textbox']/div")
    private WebElement messageFieldAssert;

    public LetterFieldsAssert(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
    }

    public boolean assertReceiver(String receiver) {
	return receiver.contains(receiverFieldAssert.getText());
    }

    public boolean assertSubject(String subject) {
	return (subjectField.getAttribute("value").contains(subject));
    }

    public boolean assertMessage(String message) {
	return messageFieldAssert.getText().contains(message);
    }

    public String getReceiver() {
	waitVisibleElement(receiverFieldAssert, RECEIVER_FIELD_MESSAGE);
	return receiverFieldAssert.getAttribute(DATA_EMAIL);
    }

    public String getSubject() {
	return subjectField.getAttribute("value");
    }

    public String getMessage() {
	return messageFieldAssert.getText();
    }

}
