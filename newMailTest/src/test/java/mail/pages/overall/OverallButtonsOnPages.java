package mail.pages.overall;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mail.pages.BasicPage;

/*
 * Кнопки, доступные из любогой другой страницы
 */
public class OverallButtonsOnPages extends BasicPage {



    @FindBy(xpath = "//*[@href=\"#compose\"]")
    private WebElement writeMessageButton;

    @FindBy(xpath = "//span[contains(@class, 'delete')]")
    protected WebElement deleteDraft;

    @FindBy(xpath = "//*[@class='mail-User-Name']")
    private WebElement userName;
    // попробуй подобрать другой локатор пожалуйста
    @FindBy(xpath = "//*[@class = 'b-user-dropdown-content']/div[8]/a")
    private WebElement logout;

    @FindBy(xpath = "//span[contains(@class, 'Refresh')]")
    private WebElement refreshButton;

    public OverallButtonsOnPages(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
    }

    // должен называться clickRefreshButton() или refresh()
    public void refreshButton() {
	new Actions(driver).click(refreshButton).build().perform();
    }
   
    public void clickWriteMessageButton() {
	new Actions(driver).click(writeMessageButton).build().perform();
    }

    public void clickDeleteButton() {

	for (int i = 0; i < ATTEMPTS; i++) {
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
