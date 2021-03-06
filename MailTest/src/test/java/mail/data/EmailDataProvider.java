package mail.data;

import org.testng.annotations.DataProvider;

import mail.utility.read.ReadDataToEmail;

/**
 * dataProvider для заполенния полей сообщения получатель тема сообщение
 */
public class EmailDataProvider {

    @DataProvider(name = "data")
    public static Object[][] dp() {
	return ReadDataToEmail.readFromCsv();
    }
}
