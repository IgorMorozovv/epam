package mail.pages.main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftPage extends Page {

    private final static String TITLE = "Черновик";

    // TODO: проверить порядок расположения полей и методов на страницах. Сначала
    // поля, потом методы
    public DraftPage(WebDriver driver) {

	super(driver);
	PageFactory.initElements(driver, this);
	title = TITLE;

    }

    private By messages = new By.ByXPath("//*[contains(@class,'js-message-snippet-body')]");

    @FindBy(xpath = "//*[contains(@class,'js-message-snippet-body')]")
    private List<WebElement> drafts;

    @FindBy(xpath = "//*[contains(@class, 'nb-checkbox-normal-flag')]")
    private List<WebElement> checkBoxDrafts;

    @FindBy(xpath = "//*[@class='checkbox_view']")
    private List<WebElement> checkAllDrafts;

    @FindBy(xpath = "//*[contains(text(), 'нет писем')]")
    private WebElement noLetters;

    public void loadLastDraft() {

	WebElement webElement = drafts.get(firstDraftIndex);
	waitVisibleElement(webElement);
	new Actions(driver).click(webElement).build().perform();
    }

    public void selectAllDrafts() {

	new Actions(driver).click(checkAllDrafts.get(firstDraftIndex)).build().perform();

    }

    public void selectLastDraft() {
	checkBoxDrafts.get(firstDraftIndex).click();
    }

    public void dropLetter() {

	waitVisibleElement(drafts.get(firstDraftIndex));
	new Actions(driver).dragAndDrop(drafts.get(firstDraftIndex), linksToMainPages.getToDelete()).build().perform();

    }

    // TODO: пример излишней декомпозиции. Просто вызови метод isDisplayed там, где
    // это необходимо. Здесь же некорректное название у метода
    public boolean noLetters() {

	return noLetters.isDisplayed();
    }

    public void waitLetters() {
	try {
	    waitVisibleElement(drafts.get(firstDraftIndex));
	} catch (NullPointerException e) {
	    e.printStackTrace();
	}

    }

    public boolean haveCheckBox() {

	return driver.findElements(messages).get(firstDraftIndex).isEnabled();
    }

}
