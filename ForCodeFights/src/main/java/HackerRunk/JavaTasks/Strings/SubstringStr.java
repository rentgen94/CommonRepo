package HackerRunk.JavaTasks.Strings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SubstringStr {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        if (s.length() <= k) {
            smallest = s;
            largest = s;
        } else {
            ArrayList<String> strs = new ArrayList<>();
            for (int i = 0; i <= s.length() - k; i++) {
                strs.add(s.substring(i, i + k));
            }
            Collections.sort(strs);
            smallest = strs.get(0);
            largest = strs.get(strs.size() - 1);
        }

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}

