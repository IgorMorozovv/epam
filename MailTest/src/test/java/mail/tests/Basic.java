package mail.tests;

import org.testng.annotations.BeforeSuite;

import mail.pages.ComposeLetterPage;
import mail.pages.DraftPage;
import mail.pages.LoginPage;
import mail.pages.MainPage;
import mail.pages.YandexMainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

public class Basic {

    public static WebDriver wDriver = new FirefoxDriver();
    protected LoginPage loginPage = new LoginPage(wDriver);
    protected MainPage mailPage = new MainPage(wDriver);
    protected DraftPage draftPage = new DraftPage(wDriver);
    protected ComposeLetterPage composeLetterPage = new ComposeLetterPage(wDriver);
    protected YandexMainPage yandexMainPage = new YandexMainPage(wDriver);

    final static String FILE_NAME = "forDraft.xml";

    @BeforeSuite
    public void beforeSute() {
	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
    }

    @AfterSuite
    public void afterSute() {
	wDriver.quit();
    }

}
