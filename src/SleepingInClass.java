import java.util.ArrayList;
import java.util.Scanner;

public class SleepingInClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i<t; i++) {
            int n = scanner.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            int sum = 0;
            for (int j = 0; j<n; j++) {
                arr.add(scanner.nextInt());
                sum+=arr.get(j);
            }
            for (int k = 0; k <= sum; k++) {
                if (k != 0 && sum % k != 0) {
                    continue;
                }
                int currSum = 0;
                boolean valid = true;
                for (int h : arr) {
                    currSum += h;
                    if (currSum > k) {
                        valid = false;
                        break;
                    } else if (currSum == k) {
                        currSum = 0;
                    }
                }
                if (valid) {
                    if (k == 0) {
                        System.out.println(0);
                    } else {
                        System.out.println(n - sum / k);
                    }
                    break;
                }
            }
        }
    }
}