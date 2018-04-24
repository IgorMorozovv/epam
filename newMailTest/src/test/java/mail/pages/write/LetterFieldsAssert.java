package mail.pages.write;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mail.pages.BasicPage;

public class LetterFieldsAssert extends BasicPage{   

    @FindBy(name = "to")
    protected WebElement receiverFieldAssert;

    @FindBy(name = "subj")
    protected WebElement subjectField;

    @FindBy(xpath = "//*[@role = 'textbox']/div")
    protected WebElement messageFieldAssert;
         
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
    
}
