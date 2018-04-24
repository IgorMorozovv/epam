package mail.pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicPage {

    protected final static int WAIT_IN_SECONDS = 10;
    protected WebDriver driver;

    public BasicPage(WebDriver driver) {
	this.driver = driver;
    }

    public void waitVisibleElement(WebElement element) {

	try {
	    new WebDriverWait(driver, WAIT_IN_SECONDS).until(ExpectedConditions.visibilityOf(element));
	} catch (ElementNotVisibleException | TimeoutException e) {
	    e.printStackTrace();
	}
    }

}
