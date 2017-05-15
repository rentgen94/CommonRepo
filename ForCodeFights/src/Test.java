import java.util.GregorianCalendar;

/**
 * Created by Western-Co on 14.11.2016.
 */
public class Test {
    static class A {
        int a;

        public A(int a) {
            this.a = a;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }
    public static void main(String[] args) {
        A testA = new A(19);
        addOne(testA);
        System.out.println(testA.getA());
    }

    private static void addOne(A c) {
        int b = c.getA() + 1;
        c.setA(c.getA() + 1);
        c = new A(27);
    }
}
