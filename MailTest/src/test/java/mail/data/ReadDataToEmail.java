package mail.data;

import mail.data.concrete.ReadFromCsv;
import mail.data.concrete.ReadFromXML;

public class ReadDataToEmail {

    public static Object[][] readFromCsv() {
	return ReadFromCsv.getData();
    }

    public static Object[][] readFromXML() {
	return ReadFromXML.getData();
    }
}
