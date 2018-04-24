package mail.pages.overall;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import mail.pages.BasicPage;

/*
 * Кнопки, доступные из любогой другой страницы
 */
public class OverallButtonsOnPages extends BasicPage {

    private final static int WAIT_TIME = 10;
    private final static int TIMES = 2;

    @FindBy(xpath = "//*[@href=\"#compose\"]")
    private WebElement writeMessageButton;

    @FindBy(xpath = "//span[contains(@class, 'delete')]")
    protected WebElement deleteDraft;

    @FindBy(xpath = "//*[@class='mail-User-Name']")
    private WebElement userName;

    @FindBy(xpath = "//*[@class = 'b-user-dropdown-content']/div[8]/a")
    private WebElement logout;

    @FindBy(xpath = "//span[contains(@class, 'Refresh')]")
    private WebElement refreshButton;

    public OverallButtonsOnPages(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
    }

    public void refreshButton() {
	new Actions(driver).click(refreshButton).build().perform();
    }

    public void waitVisibleElement(WebElement element) {

	try {
	    new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
	} catch (ElementNotVisibleException | TimeoutException e) {
	    e.printStackTrace();
	}
    }

    public void clickWriteMessageButton() {
	new Actions(driver).click(writeMessageButton).build().perform();
    }

    public void clickDeleteButton() {

	for (int i = 0; i < TIMES; i++) {
	    new Actions(driver).click(deleteDraft).build().perform();
	}
    }

    public void clickUserNameIcon() {
	new Actions(driver).click(userName).build().perform();
    }

    public void logout() {
	waitVisibleElement(logout);
	new Actions(driver).click(logout).build().perform();
    }

}
