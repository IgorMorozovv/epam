package mail.pom.tests.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverInitialization implements GetDriver {

    public WebDriver getDriver() {
	System.setProperty("webdriver.gecko.driver", "configuration//geckodriver.exe");
	return new FirefoxDriver();
    }
}
