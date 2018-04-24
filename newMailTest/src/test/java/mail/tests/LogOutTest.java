package mail.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class LogOutTest extends BasicTestClass {

    @Test(groups = { "other-functions" }, priority = 10)
    public void logOut() {
	login.log();
	inboxPage.waitTitle();
	// TODO: в классах с тестами должно идти создание переменных страниц и действия
	// с ними.
	// Пример: Инициализация поля private MainPage mainPage = new MainPage
	// Использование поля в тесте mainPage.fillSomeFields();
	commonButtons.clickUserName();
	commonButtons.logout();
	assertTrue(yandexMainPage.enterButtonIsDisplay());
    }
}
