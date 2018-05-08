package mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexMainPage extends BasicPage {

    @FindBy(xpath = ".//*[contains(@class, \"login-enter\")]")
    private WebElement enterMailButton;

    public YandexMainPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
    }

    public boolean IsDisplayedEnterButton() {
	waitVisibleElement(enterMailButton);
	return enterMailButton.isDisplayed();
    }

}
