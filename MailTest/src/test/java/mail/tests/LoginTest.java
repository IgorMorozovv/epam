package mail.tests;

import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import mail.data.LoginPageData;

public class LoginTest extends Basic {

    @Test(groups = "login")
    public void logInTest() {

	wDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wDriver.get(LoginPageData.LOGIN_URL);
	loginPage.inputLogin(LoginPageData.LOGIN);
	loginPage.inputPassword(LoginPageData.PASSWORD);
	loginPage.clickEnter();
	//wDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	assertTrue(mailPage.isLoaded());
	mailPage.clickLightVersionLink();
    }

}
