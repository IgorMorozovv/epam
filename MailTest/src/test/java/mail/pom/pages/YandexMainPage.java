package mail.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexMainPage extends BasicPage {

    private static final String ENTER_BUTTON_MESSAGE = " кнопка входа в почту";
    @FindBy(xpath = ".//*[contains(@class, \"login-enter\")]")
    private WebElement enterMailButton;

    public YandexMainPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
    }

    public boolean IsDisplayedEnterButton() {
	waitVisibleElement(enterMailButton, ENTER_BUTTON_MESSAGE);
	return enterMailButton.isDisplayed();
    }

}
