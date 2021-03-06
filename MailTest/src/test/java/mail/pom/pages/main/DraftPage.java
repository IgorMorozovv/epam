package mail.pom.pages.main;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mail.pom.pages.write.LetterFieldsAssert;

public class DraftPage extends BasePageFolder {

    private final static String TITLE = "Черновик";

    private static final String FIRST_DRAFT_MESSAGE = " первый черновик в папке";

    @FindBy(xpath = "//*[contains(@class,'js-message-snippet-body')]")
    private List<WebElement> drafts;

    @FindBy(xpath = "//*[@class='checkbox_view']")
    private List<WebElement> checkAllDrafts;

    @FindBy(xpath = "//*[contains(text(), 'нет писем')]")
    private WebElement noLettersText;

    public DraftPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	title = TITLE;
    }

    public LetterFieldsAssert clickFirstDraft() {
	WebElement webElement = drafts.get(firstDraftIndex);
	waitVisibleElement(webElement, FIRST_DRAFT_MESSAGE);
	new Actions(driver).click(webElement).build().perform();
	return new LetterFieldsAssert(driver);
    }

    public void selectAllDrafts() {
	new Actions(driver).click(checkAllDrafts.get(firstDraftIndex)).build().perform();
    }

    public void dropLetter() {
	waitVisibleElement(drafts.get(firstDraftIndex), FIRST_DRAFT_MESSAGE);
	new Actions(driver).dragAndDrop(drafts.get(firstDraftIndex), linksToMainPages.getDeleteLink()).build()
		.perform();
    }

    public boolean isDisplayLackLettersText() {
	return noLettersText.isDisplayed();
    }

    public void waitVisibleLetters() {
	waitVisibleElement(drafts.get(firstDraftIndex), FIRST_DRAFT_MESSAGE);
    }

}
