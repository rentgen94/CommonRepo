import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
        int size = scan.nextInt();
        ArrayList<Integer> arrX = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrX.add(scan.nextInt());
        }
        ArrayList<Integer> arrW = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrW.add(scan.nextInt());
        }
        double weightedMean = findWeightedMean(arrX, arrW);
        System.out.printf("%.1f", weightedMean);
    }

    private static double findWeightedMean(ArrayList<Integer> values, ArrayList<Integer> weights) {
        double ans;
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