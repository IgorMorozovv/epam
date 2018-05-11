package mail.pom.pages.main;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mail.pom.pages.BasicPage;
import mail.pom.pages.overall.LinksToMainPages;
import mail.pom.pages.overall.OverallButtonsOnPages;

public class BasePageFolder extends BasicPage {

    protected final static int firstDraftIndex = 0;

    public LinksToMainPages linksToMainPages;
    public OverallButtonsOnPages overallButtonsOnPages;
    protected String title;

    public BasePageFolder(WebDriver driver) {
	super(driver);
	linksToMainPages = new LinksToMainPages(driver);
	overallButtonsOnPages = new OverallButtonsOnPages(driver);
    }

    public BasePageFolder waitTitle() {
	try {
	    new WebDriverWait(driver, WAIT_IN_SECONDS).until(ExpectedConditions.titleContains(title));
	} catch (ElementNotVisibleException | TimeoutException e) {
	    e.printStackTrace();
	    logger.error(e.getMessage());
	}
	return this;
    }
}
