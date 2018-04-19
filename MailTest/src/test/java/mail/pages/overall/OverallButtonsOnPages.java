package mail.pages.overall;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OverallButtonsOnPages {

    public OverallButtonsOnPages(WebDriver driver) {

	PageFactory.initElements(driver, this);
	this.driver = driver;
	PageFactory.initElements(driver, this);
    }

    public WebDriver driver;

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

    public void refreshButton() {
	new Actions(driver).click(refreshButton).build().perform();

    }

    public void waitVisibleElement(WebElement element) {

	new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }

    public void clickWriteMessageButton() {

	waitVisibleElement(writeMessageButton);
	new Actions(driver).click(writeMessageButton).build().perform();
    }

    public void clickDeleteButton() {
	
	new Actions(driver).click(deleteDraft).build().perform();
    }

    public void clickUserName() {
	
	new Actions(driver).click(userName).build().perform();
    }

    public void logout() {
	
	new Actions(driver).click(logout).build().perform();
    }

}
