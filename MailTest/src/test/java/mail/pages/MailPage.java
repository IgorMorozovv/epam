package mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {

    public MailPage(WebDriver driver) {

	PageFactory.initElements(driver, this);
	this.driver = driver;
    }

    public WebDriver driver;

    By lightversion = new By.ByLinkText("Лёгкая версия");

    @FindBy(linkText = "Лёгкая версия")
    private WebElement lightVersionLink;

    @FindBy(xpath = "//*[@class=\"b-statusline\"]")
    private WebElement statusField;

    @FindBy(xpath = "//*[contains(@title, \"Написать\")]//span")
    private WebElement writeMessageButton;

    @FindBy(xpath = "//*[@aria-label=\"Написать\"]/i")
    private WebElement writeMessageButton2;

    @FindBy(xpath = "//*[contains(@aria-label, 'Входящие')]/span")
    private WebElement inputMessageButton;

    @FindBy(xpath = "//*[contains(@aria-label, 'Черновики')]/span")
    private WebElement draftLink;

    @FindBy(xpath = "//*[@aria-label='Удалить']")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[contains(@class, \"_exit\")]")
    private WebElement exitButton;

    public void clickLightVersionLink() {
	driver.findElement(lightversion).click();
    }

    public void clickWriteMessageButton() {
	writeMessageButton2.click();
    }

    public boolean isLoaded() {

	WebElement lightVersionLink = (new WebDriverWait(driver, 15))

		.until(ExpectedConditions.presenceOfElementLocated(lightversion));

	return lightVersionLink.isDisplayed();

    }

    public void clickInputButton() {
	inputMessageButton.click();
    }

    public void clickDraftLink() {
	draftLink.click();
    }

    public void clickDeleteButton() {
	deleteButton.click();
    }

    public void logOut() {
	exitButton.click();
    }

    public boolean draftSaved() {
	return statusField.isDisplayed();
    }
}
