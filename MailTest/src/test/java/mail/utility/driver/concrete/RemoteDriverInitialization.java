package mail.utility.driver.concrete;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverInitialization implements Driver {
    private static final String URL = "http://10.19.10.150:4444/wd/hub";
    URL hubURL;

    @Override
    public WebDriver getDriver() {
	try {
	    hubURL = new URL(URL);
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	    return null;
	}
	return new RemoteWebDriver(hubURL, DesiredCapabilities.chrome());
    }
}
