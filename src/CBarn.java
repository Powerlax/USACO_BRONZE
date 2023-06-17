import java.io.File;
import java.util.Scanner;

public class CBarn {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("cbarn.in"));
            int n = scanner.nextInt();
            int[] cows = new int[n];
            int total = 0;
            for (int i = 0; i<n; i++) {
                cows[i] = scanner.nextInt();
                total += cows[i];
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int dist = 0;
                int left = total;
                for (int j = 0; j < n; j++) {
                    left -= cows[(i + j) % n];
                    dist += left;
                }
                ans = Math.min(ans, dist);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int sum(int[] array) {
        int a = 0;
        for (int j : array) {
            a += j;
        }
        return a;
    }
}
