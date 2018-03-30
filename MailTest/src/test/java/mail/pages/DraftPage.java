package mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftPage extends ComposeLetterPage {

    public DraftPage(WebDriver driver) {
	super(driver);

    }

    @FindBy(xpath = "//*[contains(@class, \"message_last\")]//a[1]/span/span")
    private WebElement lastDraft;

    @FindBy(xpath = "//*[contains(@class, \"message_last\")]//*[@name = 'ids']")
    private WebElement checkLastDrat;

    @FindBy(id = "check-all")
    private WebElement checkAllDrafts;

    public void loadLastDraft() {
	lastDraft.click();
    }

    public void selectAllDrafts() {
	checkAllDrafts.click();
    }

    public void selectLastDraft() {
	checkLastDrat.click();
    }

}
