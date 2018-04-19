package mail.pages.overall;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinksToMainPages extends OverallButtonsOnPages {

    public LinksToMainPages(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@href='#draft']/span")
    private WebElement toDraftPage;

    @FindBy(xpath = "//*[@href='#sent']/span")
    private WebElement toSentMessagesMessages;

    @FindBy(xpath = "//*[@href='#inbox']//span")
    protected WebElement toInBox;

   
    @FindBy(xpath = "//*[@href='#trash']/span")
    protected WebElement toDelete;

 

    public void waitVisibleElement(WebElement element) {

	new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));

    }

    public void toDraftLinkClick() {

	
	new Actions(driver).click(toDraftPage).build().perform();
    }

    public void toSentMessageClick() {

	new Actions(driver).click(toSentMessagesMessages).build().perform();

    }

    public void ToInboxClick() {
	new Actions(driver).click(toInBox).build().perform();
    }

    public WebElement getToDelete() {
	return toDelete;
    }

}
