package mail.pages.main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftPage extends BasePageFolder {

    private final static String TITLE = "Черновик";
    
    private By messages = new By.ByXPath("//*[contains(@class,'js-message-snippet-body')]");

    @FindBy(xpath = "//*[contains(@class,'js-message-snippet-body')]")
    private List<WebElement> drafts;

    @FindBy(xpath = "//*[@class='checkbox_view']")
    private List<WebElement> checkAllDrafts;

    @FindBy(xpath = "//*[contains(text(), 'нет писем')]")
    private WebElement noLetters;

    public DraftPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	title = TITLE;
    }

    public void clickFirstDraft() {
	WebElement webElement = drafts.get(firstDraftIndex);
	waitVisibleElement(webElement);
	new Actions(driver).click(webElement).build().perform();
    }

    public void selectAllDrafts() {
	new Actions(driver).click(checkAllDrafts.get(firstDraftIndex)).build().perform();
    }

    public void dropLetter() {
	waitVisibleElement(drafts.get(firstDraftIndex));
	new Actions(driver).dragAndDrop(drafts.get(firstDraftIndex), linksToMainPages.getDeleteLink()).build()
		.perform();
    }

    public boolean isDisplayLackLettersText() {
	return noLetters.isDisplayed();
    }

    public void waitVisibleLetters() {
	waitVisibleElement(drafts.get(firstDraftIndex));
    }
}
