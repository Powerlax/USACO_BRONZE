import java.util.Arrays;
import java.util.Scanner;

public class CowCollege {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i<n; i++) {
            data[i] = scanner.nextInt();
        }
        Arrays.sort(data);
        long best = -1L;
        int cost = 0;
        for (int i = n-1; i>0; i--) {
            long total = (long)(n-i)*(long)data[i];
            if ((total >= best)) {
                best = total;
                cost = data[i];
            }
        }

        System.out.println(best + " " + cost);
    }
}
