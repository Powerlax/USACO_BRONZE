import java.util.Scanner;

public class StaticRangeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        long[] data = new long[n];
        for (int i = 0; i<n; i++) {
            data[i] = scanner.nextInt();
        }
        long[] prefix = new long[n+1];
        for (int i = 0; i<n; i++) {
            prefix[i+1] = prefix[i] + data[i];
        }
        for (int i = 0; i<q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(prefix[r] - prefix[l]);
        }

    }
}
