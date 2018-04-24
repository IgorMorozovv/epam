package mail.pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends Page {

    private final static String TITLE = "Входящие";

    public InboxPage(WebDriver driver) {

	super(driver);
	PageFactory.initElements(driver, this);
	title = TITLE;
    }

    // TODO: старайся избегать таких названий title1.
    // TODO:Удали лишние поля и методы, которые нигде не используются.
    @FindBy(xpath = "//title")
    WebElement title1;

    // TODO: Старайся не оставлять пустые строки там, где нет необходимости.
    // Нарушается читабельность кода.
    // TODO: Некорректное название метода. isTitleLoad будет понятнее.
    public boolean isLoad() {

	waitTitle();
	// TODO: объедини 27 и 28 строки
	String currentTitle;
	currentTitle = driver.getTitle();
	return currentTitle.contains(title);

    }

}
