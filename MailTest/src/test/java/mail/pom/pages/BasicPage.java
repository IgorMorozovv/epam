package mail.pom.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicPage {

    protected final static int ATTEMPTS = 2;
    protected final static int WAIT_IN_SECONDS = 10;
    protected WebDriver driver;

    protected Logger logger = Logger.getLogger(this.getClass());

    public BasicPage(WebDriver driver) {
	this.driver = driver;
    }

    public void waitVisibleElement(WebElement element) {
	try {
	    new WebDriverWait(driver, WAIT_IN_SECONDS).until(ExpectedConditions.visibilityOf(element));
	} catch (ElementNotVisibleException | TimeoutException e) {
	    // TODO: см BasePageFolder
	    e.printStackTrace();
	    logger.error(e.getMessage());
	}
    }
}
