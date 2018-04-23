package mail.pages.main;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mail.pages.overall.LinksToMainPages;
import mail.pages.overall.OverallButtonsOnPages;

public class Page {

    protected WebDriver driver;
    protected LinksToMainPages linksToMainPages;
    protected OverallButtonsOnPages overallButtonsOnPages;

    protected String title;
    protected final static int waitTime = 10;
    protected final static int firstDraftIndex = 0;

    public Page(WebDriver driver) {

	this.driver = driver;
	linksToMainPages = new LinksToMainPages(driver);
	overallButtonsOnPages = new OverallButtonsOnPages(driver);

    }

    public void waitVisibleElement(WebElement element) {

	try {
	    new WebDriverWait(driver, waitTime).until(ExpectedConditions.visibilityOf(element));
	} catch (ElementNotVisibleException e) {
	    e.printStackTrace();
	}
	catch (TimeoutException e) {
	   e.printStackTrace();
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
	

    }

    public void waitTitle() {
	try {
	    new WebDriverWait(driver, waitTime).until(ExpectedConditions.titleContains(title));
	} catch (ElementNotVisibleException e) {
	    e.printStackTrace();
	}
	catch (TimeoutException e) {
	   e.printStackTrace();
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
	
    }

}
