import java.util.Scanner;

public class HungryCow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();
        long T = scanner.nextLong();

        long[][] deliveries = new long[(int) (N + 1)][2]; // Extra row for the (T+1, 0) delivery
        for (int i = 0; i < N; i++) {
            deliveries[i][0] = scanner.nextLong();
            deliveries[i][1] = scanner.nextLong();
        }
        deliveries[(int) N][0] = T + 1;
        deliveries[(int) N][1] = 0;

        long remaining = 0, total = 0, lastD = 0;
        for (long[] delivery : deliveries) {
            long d = delivery[0];
            long b = delivery[1];

            total += b;
            remaining -= d - lastD;
            lastD = d;
            remaining = Math.max(remaining, 0) + b;
        }

        System.out.println(total - remaining);
    }
}
