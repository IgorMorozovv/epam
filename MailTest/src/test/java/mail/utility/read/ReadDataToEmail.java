package mail.utility.read;

import mail.utility.read.concrete.ReadFromCsv;
import mail.utility.read.concrete.ReadFromXML;

public class ReadDataToEmail {

    public static Object[][] readFromCsv() {
	return ReadFromCsv.getData();
    }

    public static Object[][] readFromXML() {
	return ReadFromXML.getData();
    }
}
