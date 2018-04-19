package mail.pages.write;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LetterFieldsAssert {

    public LetterFieldsAssert(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = " //*[@class=\"mail-Bubble-Block\"]/span[2]")
    protected WebElement receiverFieldAssert;

    @FindBy(name = "subj")
    protected WebElement subjectField;

    @FindBy(xpath = "//*[@role = 'textbox']/div")
    protected WebElement messageFieldAssert;

    By submitButton = new By.ByXPath(".//*[@type = 'submit']");

    public boolean assertReceiver(String receiver) {

	
	return receiver.contains(receiverFieldAssert.getText());
    }

    public boolean assertSubject(String subject) {
	return (subjectField.getAttribute("value").contains(subject));
    }

    public boolean assertMessage(String message) {
	return messageFieldAssert.getText().contains(message);
    }

    public String getReceiced() {

	return null;
    }
}
