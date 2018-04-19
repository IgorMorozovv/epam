package mail.pages.main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftPage extends Page {

    String TITLE = "Черновик";

    public DraftPage(WebDriver driver) {

	super(driver);
	PageFactory.initElements(driver, this);
	title = TITLE;

    }

    @FindBy(xpath = "//*[contains(@class,'js-message-snippet-body')]")
    List<WebElement> drafts;

    @FindBy(xpath = "//*[contains(@class,'mail-MessageSnippet-Content')]")
    List<WebElement> drafts2;

    @FindBy(xpath = "//*[contains(@class, 'title-add-template')]")
    WebElement createTemplate;

    By lastDraftBy = new By.ByXPath("//*[contains(@class,'js-message-snippet-body')]");

    @FindBy(xpath = "//*[contains(@class, 'nb-checkbox-normal-flag')]")
    List<WebElement> checkBoxDrafts;

    @FindBy(xpath = "//*[@class='checkbox_view']")
    private List<WebElement> checkAllDrafts;

    @FindBy(xpath = "//*[contains(text(), 'нет писем')]")
    WebElement noLetters;

    public void loadLastDraft() {

	WebElement webElement = drafts.get(drafts.size() - 1);
	waitVisibleElement(webElement);
	new Actions(driver).click(webElement).build().perform();
    }

    public void selectAllDrafts() {

	new Actions(driver).click(checkAllDrafts.get(0)).build().perform();
    }

    public void selectLastDraft() {
	checkBoxDrafts.get(checkBoxDrafts.size() - 1).click();
    }

    public void dropLetter() {

	waitVisibleElement(drafts.get(0));
	new Actions(driver).dragAndDrop(drafts.get(drafts.size() - 1), linksToMainPages.getToDelete()).build()
		.perform();

    }

    public boolean noLetters() {

	return noLetters.isDisplayed();
    }

}
