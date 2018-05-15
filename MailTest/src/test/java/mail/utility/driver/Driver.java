package mail.utility.driver;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import mail.configuration.ReadConfiguration;

public class Driver {

    private static final String START_BY_HUB = "hub";
    private static WebDriver driver;

    private static String start = ReadConfiguration.getTypeOfDriver();
    private FirefoxDriverInitialization firefoxDriverInitialization;
    private RemoteDriverInitialization remoteDriverInitialization;

    public WebDriver getDriver() throws MalformedURLException {
	if (driver == null) {
	    switch (start) {
	    case START_BY_HUB:
		remoteDriverInitialization = new RemoteDriverInitialization();
		return remoteDriverInitialization.getDriver();
	    default:
		firefoxDriverInitialization = new FirefoxDriverInitialization();
		return firefoxDriverInitialization.getDriver();
	    }
	}
	return driver;
    }
}
