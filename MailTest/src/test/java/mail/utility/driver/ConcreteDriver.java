package mail.utility.driver;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import mail.configuration.ReadConfiguration;
import mail.utility.driver.concrete.Driver;
import mail.utility.driver.concrete.FirefoxDriverInitialization;
import mail.utility.driver.concrete.RemoteDriverInitialization;

public class ConcreteDriver {

    private static final String START_BY_HUB = "hub";

    private static String start = ReadConfiguration.getTypeOfDriver();
    private Driver driver;

    public WebDriver getDriver() throws MalformedURLException {
	switch (start) {
	case START_BY_HUB:
	    driver = new RemoteDriverInitialization();
	    return driver.getDriver();
	default:
	    driver = new FirefoxDriverInitialization();
	    return driver.getDriver();
	}
    }
}
