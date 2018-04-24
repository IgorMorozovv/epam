package mail.pages.overall;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OverallButtonsOnPages {

    private final static int WAIT_TIME = 10;
    private final static int TIMES = 2;

    /*
     * Кнопки, доступные из любогой другой страницы
     */
    public OverallButtonsOnPages(WebDriver driver) {
	// TODO: выглядит странно. Зачем дважды инициализировать элементы?
	PageFactory.initElements(driver, this);
	this.driver = driver;
	PageFactory.initElements(driver, this);
    }

    // TODO: сначала объявляются открытые поля, затем защищенные, затем приватные
    public WebDriver driver;

    @FindBy(xpath = "//*[@href=\"#compose\"]")
    private WebElement writeMessageButton;

    @FindBy(xpath = "//span[contains(@class, 'delete')]")
    protected WebElement deleteDraft;

    @FindBy(xpath = "//*[@class='mail-User-Name']")
    private WebElement userName;

    // TODO: не очень удачный вариант локатора
    @FindBy(xpath = "//*[@class = 'b-user-dropdown-content']/div[8]/a")
    private WebElement logout;

    @FindBy(xpath = "//span[contains(@class, 'Refresh')]")
    private WebElement refreshButton;

    public void refreshButton() {
	new Actions(driver).click(refreshButton).build().perform();

    }

    public void waitVisibleElement(WebElement element) {

	try {
	    new WebDriverWait(driver, WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
	} catch (ElementNotVisibleException e) {
	    e.printStackTrace();
	} catch (TimeoutException e) {
	    e.printStackTrace();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void clickWriteMessageButton() {

	new Actions(driver).click(writeMessageButton).build().perform();
    }

    public void clickDeleteButton() {

	for (int i = 0; i < TIMES; i++) {
	    new Actions(driver).click(deleteDraft).build().perform();
	}

    }

    public void clickUserName() {

	new Actions(driver).click(userName).build().perform();
    }

    public void logout() {
	// TODO: лучше вынести одинаковые ожидание в отдельное место, мб в базовый класс
	// и оттуда дергать. Я уже видела такой метод в классе LinksToMainPage
	new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(logout));
	new Actions(driver).click(logout).build().perform();
    }

}
