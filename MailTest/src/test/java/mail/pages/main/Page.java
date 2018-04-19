package mail.pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mail.pages.overall.LinksToMainPages;
import mail.pages.overall.OverallButtonsOnPages;

public class Page {

    protected WebDriver driver;
    LinksToMainPages linksToMainPages;
    OverallButtonsOnPages overallButtonsOnPages;

    protected String title;

    public Page(WebDriver driver) {

	this.driver = driver;
	linksToMainPages = new LinksToMainPages(driver);
	overallButtonsOnPages = new OverallButtonsOnPages(driver);

    }

    public void waitVisibleElement(WebElement element) {

	new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));

    }

    public void waitTitle() {
	new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains(title));
    }

    protected void setTitle(String title) {
	this.title = title;
    }
}
