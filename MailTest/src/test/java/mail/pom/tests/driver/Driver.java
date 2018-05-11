package mail.pom.tests.driver;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import mail.configuration.ReadConfiguration;

public class Driver {

    private static final String START_BY_HUB = "hub";

    private static String start = ReadConfiguration.getTypeOfDriver();
    private FirefoxDriverInitialization firefoxDriverInitialization;
    private RemoteDriverInitialization remoteDriverInitialization;

    public WebDriver getDriver() throws MalformedURLException {

	switch (start) {
	case START_BY_HUB:
	    remoteDriverInitialization = new RemoteDriverInitialization();
	    return remoteDriverInitialization.getDriver();
	default:
	    firefoxDriverInitialization = new FirefoxDriverInitialization();
	    return firefoxDriverInitialization.getDriver();
	}
    }
}
