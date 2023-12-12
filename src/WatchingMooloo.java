import java.util.Scanner;

public class WatchingMooloo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        long[] data = new long[n];
        for (int i = 0; i<n; i++) {
            data[i] = scanner.nextLong();
        }
        long moonies = k+1; //basically the i=0
        for (int i = 1; i<n; i++) {
            moonies += Math.min(k+1,data[i]-data[i-1]);
        }
        System.out.println(moonies);
    }
}
