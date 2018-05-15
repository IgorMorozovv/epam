package mail.utility.driver.concrete;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverInitialization implements Driver {

    @Override
    public WebDriver getDriver() {
	System.setProperty("webdriver.gecko.driver", "configuration//geckodriver.exe");
	return new FirefoxDriver();
    }
}
