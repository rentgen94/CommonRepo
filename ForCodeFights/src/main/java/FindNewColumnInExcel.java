import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Created by shurbin on 14.02.2017.
 */
public class FindNewColumnInExcel {
    public static void main(String[] args) {
        String pathName = "D:/Errors.xml";
        String fileCreateTable = "D:/testcolumns";
        File inputFile = new File(pathName);
        File createTable = new File(fileCreateTable);
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();
        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( createTable.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        String columnsCheck = sb.toString();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        Document xmlDocument = null;
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            xmlDocument = dBuilder.parse(inputFile);
            NodeList nList = xmlDocument.getElementsByTagName("ColName");
            for (int i = 0; i < nList.getLength(); i++) {
                String name = nList.item(i).getTextContent();
                if (sb.indexOf(name) == -1) {
                    System.out.println("Cant find column: " + name);
                }
            }
        }catch (FileNotFoundException e) {
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
