package mail.pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends BasePageFolder {

    private final static String TITLE = "Входящие";

    public InboxPage(WebDriver driver) {

	super(driver);
	PageFactory.initElements(driver, this);
	title = TITLE;
    }

    public boolean isTitleLoad() {
	waitTitle();
	return driver.getTitle().contains(title);
    }
    
}
