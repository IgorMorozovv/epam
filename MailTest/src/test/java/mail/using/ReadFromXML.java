package mail.using;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadFromXML {

    static Object[][] data;
    static String MAIN_NODE = "draft";
    static String TO_NODE = "to";
    static String SUBJECT_NODE = "subject";
    static String MESSAGE_NODE = "message";
    static int NUMBER_LETTER_FIELD = 3;

    public static Object[][] getData(String fileName) {
	try {

	    final File xmlFile = new File(fileName);

	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    Document doc = db.parse(xmlFile);

	    doc.getDocumentElement().normalize();
	    NodeList nList = doc.getElementsByTagName(MAIN_NODE);
	    data = new Object[nList.getLength()][NUMBER_LETTER_FIELD];

	    readNode(nList);
	} catch (Exception e) {
	    return null;
	}

	return data;

    }

    private static void readNode(NodeList nList) {
	for (int temp = 0; temp < nList.getLength(); temp++) {
	    Node nNode = nList.item(temp);

	    Element eElement = (Element) nNode;

	    data[temp][0] = eElement.getElementsByTagName(TO_NODE).item(0).getTextContent();

	    data[temp][1] = eElement.getElementsByTagName(SUBJECT_NODE).item(0).getTextContent();

	    data[temp][2] = eElement.getElementsByTagName(MESSAGE_NODE).item(0).getTextContent();

	}

    }

}
