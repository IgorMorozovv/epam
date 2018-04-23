package mail.pages.write;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WriteLetterPage {

    private final static int WAIT_TIME = 10;

    public WriteLetterPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver = driver;

    }

    public WebDriver driver;

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

    public void waitVisibleElement(WebElement element) {

	new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.visibilityOf(element));

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

	new Actions(driver).click(messageField).build().perform();
	new Actions(driver).sendKeys(messageField, message).build().perform();

    }

    public void clickSubmitButton() {

	new Actions(driver).click(submitButton).build().perform();

    }

    public void save() {
	new Actions(driver).keyDown(Keys.CONTROL).sendKeys("S").keyUp(Keys.CONTROL).build().perform();
	new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.visibilityOf(textBySaved));

    }

    public boolean SavedTextVisible() {

	return textBySaved.isDisplayed();
    }

    public void clickByMessageField() {
	new Actions(driver).click(messageField).build().perform();

    }
}
