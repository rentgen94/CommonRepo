import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CountRowCount {
    public static void main(String[] args) {
        try {
            System.out.println(Files.lines(Paths.get(args[0])).count());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
