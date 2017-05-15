import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Western-Co on 22.03.2017.
 */
public class FileForWorkWithProperties {
    public static void main(String[] args) {
        String path = FileForWorkWithProperties.class.getClassLoader().getResource("property/TestProperties.properties").getPath();
        showProperties(path);
        File file = new File("./src/main/resources/property/TestProperties.properties");
        path = file.getPath();
        System.out.println(path);
        createProperties(path);
        path = FileForWorkWithProperties.class.getClassLoader().getResource("property/TestProperties.properties").getPath();
        showProperties(path);
    }

    public static void createProperties(String pathToProperty){
        Properties prop = new Properties();
        try (OutputStream output = new FileOutputStream(pathToProperty)) {

            // set the properties value
            prop.setProperty("database", "localhost");
            prop.setProperty("dbuser", "mkyong");
            prop.setProperty("dbpassword", "password");
            prop.setProperty("dbpassword22test", "password");

            // save properties to project root folder
            prop.store(output, null);
            System.out.println("File written!");

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
    public static void showProperties(String pathToProperty) {
        Properties prop = new Properties();
        try (InputStream is = new FileInputStream(pathToProperty)) {
            prop.load(is);

            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                System.out.println("Key : " + key + ", Value : " + value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
