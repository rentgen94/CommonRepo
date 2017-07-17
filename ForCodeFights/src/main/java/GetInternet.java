import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.net.*;

/**
 * Created by shurbin on 17.07.2017.
 */
public class GetInternet {
    public static void main(String[] args) {
        URL url = null;
        HttpURLConnection con;
        Proxy proxy = null;
        try {
            url = new URL("http://www.google.com");
            SocketAddress sa = new InetSocketAddress("192.168.2.1", 8080);
            proxy = new Proxy(Proxy.Type.HTTP, sa);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                System.out.println("Test connection");
                con = (HttpURLConnection) url.openConnection(proxy);
                con.connect();
                int answer = con.getResponseCode();
                if (answer == 200 || answer == 302) {
                    System.out.println("Connection established!");
                } else {
                    System.out.println("No connection!");
                    refreshPage();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                refreshPage();
            }
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void refreshPage() {
        try {
            Robot robot = new Robot();
//                        robot.delay(5000);
//                        PointerInfo a = MouseInfo.getPointerInfo();
//                        Point b = a.getLocation();
//                        System.out.println("x: " + b.getX() + " y: " + b.getY());
            moveAndPress(robot, 399, 1004);
            moveAndPress(robot, 32, 13);
            moveAndPress(robot, 73, 46);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void moveAndPress(Robot robot, int x, int y) {
        robot.mouseMove(x, y);
        robot.delay(3000);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(3000);
    }
}
