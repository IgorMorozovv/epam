package mail.pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends Page {

    String TITLE = "Входящие";

    public InboxPage(WebDriver driver) {

	super(driver);
	PageFactory.initElements(driver, this);
	title = TITLE;
    }

    @FindBy(xpath = "//title")
    WebElement title1;

    public boolean isLoad() {
	waitTitle();
	String currentTitle;
	currentTitle = driver.getTitle();
	return currentTitle.contains(title);

    }

}
