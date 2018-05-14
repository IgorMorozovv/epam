package mail.pom.pages.overall;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mail.pom.pages.BasicPage;
import mail.pom.pages.YandexMainPage;
import mail.pom.pages.write.WriteLetterPage;

/*
 * Кнопки, доступные из любогой другой страницы
 */
public class OverallButtonsOnPages extends BasicPage {

    private static final String LOGOUT_BUTTON_MESSAGE = " кнопка выхода из почты";

    @FindBy(xpath = "//*[@href=\"#compose\"]")
    private WebElement writeMessageButton;

    @FindBy(xpath = "//span[contains(@class, 'delete')]")
    protected WebElement deleteDraft;

    @FindBy(xpath = "//*[@class='mail-User-Name']")
    private WebElement userName;

    @FindBy(xpath = "//*[contains(text(),'Выйти')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//span[contains(@class, 'Refresh')]")
    private WebElement refreshButton;

    public OverallButtonsOnPages(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
    }

    public void clickRefreshButton() {
	new Actions(driver).click(refreshButton).build().perform();
    }

    public WriteLetterPage clickWriteMessageButton() {
	new Actions(driver).click(writeMessageButton).build().perform();
	return new WriteLetterPage(driver);
    }

    public void clickDeleteButton() {
	new Actions(driver).click(deleteDraft).build().perform();
    }

    public void clickUserNameIcon() {
	new Actions(driver).click(userName).build().perform();
    }

    public YandexMainPage logout() {
	waitVisibleElement(logoutButton, LOGOUT_BUTTON_MESSAGE);
	new Actions(driver).click(logoutButton).build().perform();
	return new YandexMainPage(driver);
    }

}
