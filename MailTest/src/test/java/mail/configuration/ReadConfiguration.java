package mail.configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadConfiguration {

    private static final String PATH_TO_CONFIGURATION = "configuration\\configuration.xml";

    // Узлы в xml документе
    private static final String BROWSER_NAME_MESSAGE = "browserName";
    private static final String PATH_TO_DATA_MESSAGE = "pathToData";
    private static final String TYPE_OF_DRIVER_MESSAGE = "typeOfDriver";
    private static final String MAIN_NODE = "configuration";

    // Индекс в списке узлов
    private static final int NODE_POSITION = 0;

    // Данные конфигурации
    private static String browserName;
    private static String pathToData;
    private static String typeOfDriver;

    public static void getData() {
	try {
	    File xmlFile = new File(PATH_TO_CONFIGURATION);
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    Document doc = db.parse(xmlFile);
	    doc.getDocumentElement().normalize();
	    NodeList nList = doc.getElementsByTagName(MAIN_NODE);
	    readNode(nList);
	} catch (FileNotFoundException | ParserConfigurationException | SAXException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    private static void readNode(NodeList nList) {
	for (int temp = 0; temp < nList.getLength(); temp++) {

	    // Элемент корневого узла configuration
	    Element eElement = (Element) nList.item(NODE_POSITION);

	    browserName = eElement.getElementsByTagName(BROWSER_NAME_MESSAGE).item(NODE_POSITION).getTextContent();
	    pathToData = eElement.getElementsByTagName(PATH_TO_DATA_MESSAGE).item(NODE_POSITION).getTextContent();
	    typeOfDriver = eElement.getElementsByTagName(TYPE_OF_DRIVER_MESSAGE).item(NODE_POSITION).getTextContent();
	}
    }

    public static String getBrowserName() {
	getData();
	return browserName;
    }

    public static String getPathToData() {
	getData();
	return pathToData;
    }

    public static String getTypeOfDriver() {
	getData();
	return typeOfDriver;
    }  
}
