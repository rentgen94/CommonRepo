package HackerRunk.JavaTasks.Strings;

import java.util.Scanner;

public class StrReversce {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */

        boolean flag = true;
        for (int i = 0; i < A.length() / 2; i++) {
            if (A.charAt(i) != A.charAt(A.length() - 1 - i)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
