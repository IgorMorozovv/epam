package mail.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import mail.configuration.ReadConfiguration;

public class ReadFromXML implements Read {

    private static Object[][] data;
    private static String MAIN_NODE = "draft";
    private static String TO_NODE = "to";
    private static String SUBJECT_NODE = "subject";
    private static String MESSAGE_NODE = "message";
    private static int NUMBER_LETTER_FIELD = 3;

    @Override
    public Object[][] getData() {

	try {
	    File xmlFile = new File(ReadConfiguration.getPathToData());
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    Document doc = db.parse(xmlFile);
	    doc.getDocumentElement().normalize();
	    NodeList nList = doc.getElementsByTagName(MAIN_NODE);
	    data = new Object[nList.getLength()][NUMBER_LETTER_FIELD];
	    readNode(nList);
	} catch (FileNotFoundException | ParserConfigurationException | SAXException e) {
	    return null;
	} catch (IOException e) {
	    return null;
	}
	return data;
    }

    private void readNode(NodeList nList) {
	for (int temp = 0; temp < nList.getLength(); temp++) {
	    Node nNode = nList.item(temp);
	    Element eElement = (Element) nNode;
	    data[temp][0] = eElement.getElementsByTagName(TO_NODE).item(0).getTextContent();
	    data[temp][1] = eElement.getElementsByTagName(SUBJECT_NODE).item(0).getTextContent();
	    data[temp][2] = eElement.getElementsByTagName(MESSAGE_NODE).item(0).getTextContent();
	}
    }

}
