import java.util.ArrayList;
import java.util.Scanner;

public class Fintex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ans;
        ans = scanner.nextLine();
        System.out.println(ans);
//        int n = scanner.nextInt();
//        ArrayList<Integer> numbers = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            numbers.add(scanner.nextInt());
//        }
//        int needed = 0;
//        int currentAmount = 0;
//        for (int i = 0; i < numbers.size(); i++) {
//            switch (numbers.get(i)) {
//                case 5:
//                    currentAmount++;
//                    break;
//                case 10:
//                    if (currentAmount < 1) {
//                        needed++;
//                    } else {
//                        currentAmount--;
//                    }
//                    break;
//                case 50:
//                    if (currentAmount < 9) {
//                        needed += (9 - currentAmount);
//                        currentAmount = 0;
//                    } else {
//                        currentAmount -= 9;
//                    }
//                    break;
//                case 100:
//                    if (currentAmount < 19) {
//                        needed += (19 - currentAmount);
//                        currentAmount = 0;
//                    } else {
//                        currentAmount -= 19;
//                    }
//                    break;
//            }
//        }
//        int ans = 0;
//        int min = 0;
//        for (int i = 0; i < n; i++) {
//            if (numbers.get(i) != 5) {
//                ans -= numbers.get(i)/5 - 1;
//            } else {
//                ans++;
//            }
//            if (ans < min) {
//                min = ans;
//            }
//        }
//        System.out.println(needed);
//        System.out.println(-min);
    }
}
