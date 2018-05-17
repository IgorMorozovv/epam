package mail.pom.driver;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import mail.configuration.ReadConfiguration;
import mail.pom.driver.concrete.Driver;
import mail.pom.driver.concrete.FirefoxDriverInitialization;
import mail.pom.driver.concrete.RemoteDriverInitialization;

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
