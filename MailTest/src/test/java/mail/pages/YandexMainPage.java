package mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexMainPage {

    public YandexMainPage(WebDriver driver) {

	PageFactory.initElements(driver, this);
	this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = ".//*[contains(@class, \"login-enter\")]")
    private WebElement enterMailButton;

    public boolean enterButtonIsDisplay() {
	return enterMailButton.isDisplayed();
    }

}
