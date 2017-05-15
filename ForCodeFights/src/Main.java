import com.sun.xml.internal.bind.v2.schemagen.xmlschema.*;
import org.w3c.dom.*;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by shurbin on 09.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        String path = "C:\\output\\";
        String fileName = "outputxml.xml";
        String pathName = path + fileName;
        int fileNumber = 1;
        String outputFileToFormat = "out_%d.xml";
        String outputFile = String.format(outputFileToFormat, fileNumber);
        File inputFile = new File(pathName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        org.w3c.dom.Document xmlDocument = null;
        Document newXmlDoc = null;
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            xmlDocument = dBuilder.parse(inputFile);
            NodeList nList = xmlDocument.getElementsByTagName("ReqText");
            newXmlDoc = dBuilder.newDocument();
            Element rootElement = newXmlDoc.createElement(xmlDocument.getDocumentElement().getTagName());
            System.out.println("Длина списка: " + nList.getLength());
            int rows = 5000;
            System.out.println("Будет " + Math.ceil((double) (nList.getLength())/ (double) rows));
            for (int i = 0; i < nList.getLength(); i++) {
                Node reqText = newXmlDoc.importNode(nList.item(i), true);
                rootElement.appendChild(reqText);
                if ((i % rows) == 0 && i != 0) {
                    newXmlDoc.appendChild(rootElement);
                    Transformer t = TransformerFactory.newInstance().newTransformer();
                    t.setOutputProperty(OutputKeys.METHOD, "xml");
                    t.setOutputProperty(OutputKeys.INDENT, "yes");
                    t.transform(new DOMSource(newXmlDoc), new StreamResult(new FileOutputStream(new File(path + outputFile))));
                    System.out.println("Создали: " + outputFile);
                    fileNumber++;
                    System.out.println(fileNumber);
                    outputFile = String.format(outputFileToFormat, fileNumber);
                    System.out.println("Следующий файл: " + outputFile);
                    newXmlDoc = dBuilder.newDocument();
                    rootElement = newXmlDoc.createElement(xmlDocument.getDocumentElement().getTagName());
                }
            }
            newXmlDoc.appendChild(rootElement);
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.METHOD, "xml");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.transform(new DOMSource(newXmlDoc), new StreamResult(new FileOutputStream(new File(path + outputFile))));
            System.out.println("Создали: " + outputFile);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
