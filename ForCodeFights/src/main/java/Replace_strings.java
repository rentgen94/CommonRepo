import java.io.*;
import java.nio.file.Files;

/**
 * Created by shurbin on 21.09.2016.
 */
public class Replace_strings {
    public static void main(String[] args) {
        File folder = new File("C:\\My folder\\Projects\\TechModel\\techmodel\\libst\\src");
        File[] folderEntries = folder.listFiles();
        for (File entry: folderEntries) {
            if (entry.isFile()){
                if (entry.getName().endsWith("cpp")){
                    byte[] bytes = new byte[0];
                    try {
                        bytes = Files.readAllBytes(entry.toPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String content = null;
                    try {
                        content = new String(bytes, "cp1251");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    String AfterReplace = content.replace("getRefByName", "GetRefByName");
                    try (OutputStream writer = new FileOutputStream(entry)) {
                        writer.write(AfterReplace.getBytes("cp1251"));
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
