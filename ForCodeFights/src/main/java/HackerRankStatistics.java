import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class HackerRankStatistics {
    private static final Logger log = LogManager.getLogger(HackerRankStatistics.class);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
        int size = scan.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(scan.nextInt());
        }
        double mean = findMean(arr);
        double median = findMedian(arr);
        int mode = findMode(arr);
        System.out.printf("%.1f%n", mean);
        System.out.printf("%.1f%n", median);
        System.out.printf("%d%n", mode);
    }

    public static double findMean(ArrayList<Integer> arr) {
        Integer sum = 0;
        for (Integer value : arr) {
            sum += value;
        }
        double ans = sum/(double) arr.size();
        log.info("Mean is: " + ans);
        return ans;
    }

    public static double findMedian(ArrayList<Integer> arr) {
        arr.sort(Integer::compareTo);
        if (arr.size() % 2 == 1) {
            return arr.get(arr.size()/2);
        } else {
            return (arr.get(arr.size()/2 - 1) + arr.get(arr.size()/2))/2.0;
        }
    }

    public static Integer findMode(ArrayList<Integer> arr) {
        Integer ans = 0;
        ArrayList<Integer> counts = new ArrayList<>(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            int count = 0;
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(i).equals(arr.get(j))) {
                    count++;
                }
            }
            counts.add(count);
        }
        int maxCount = 0;
        int j = 0;
        for (int i = 0; i < counts.size(); i++) {
            if (counts.get(i) > maxCount) {
                maxCount = counts.get(i);
                j = i;
            }
        }
        ans = arr.get(j);
        return ans;
    }

    private static double findWeightedMean(ArrayList<Integer> values, ArrayList<Integer> weights) {
        double ans = 0.0;
        double sum = 0.0;
        double weightSum = 0.0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i) * weights.get(i);
            weightSum += weights.get(i);
        }
        ans = sum / weightSum;
        return ans;
    }
}