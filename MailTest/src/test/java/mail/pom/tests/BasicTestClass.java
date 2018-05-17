package mail.pom.tests;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.uncommons.reportng.HTMLReporter;

import mail.buisnes.LoginLogout;
import mail.configuration.ReadConfiguration;
import mail.pom.driver.ConcreteDriver;
import mail.pom.pages.main.DraftPage;
import mail.pom.pages.main.InboxPage;
import mail.pom.pages.write.WriteLetterPage;

@Listeners({ HTMLReporter.class })
public class BasicTestClass {

    protected static final String FILE_NAME = ReadConfiguration.getPathToData();
    private static final int WAIT_TIME = 10;

    protected WebDriver driver;
    protected InboxPage inboxPage;
    protected DraftPage draftPage;
    protected WriteLetterPage writeLetterPage;
    protected LoginLogout loginLogout;
    protected Logger logger = Logger.getLogger(getClass());
    private ConcreteDriver concreteDriver = new ConcreteDriver();

    @BeforeClass
    public void basicTestClass() throws MalformedURLException {
	// setDriver();
	// loginLogout = new LoginLogout(driver);
	// driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
    }

    protected void setDriver() throws MalformedURLException {
	if (driver == null) {
	    driver = concreteDriver.getDriver();
	}
    }

}
