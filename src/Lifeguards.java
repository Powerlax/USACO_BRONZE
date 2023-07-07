import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lifeguards {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("lifeguards.in"));
        int n = Integer.parseInt(scanner.nextLine());
        int[] start = new int[n];
        int[] end = new int[n];
        int[] time = new int[1000];
        for (int i = 0; i < n; i++) {
            start[i] = scanner.nextInt();
            end[i] = scanner.nextInt();
            for (int j = start[i]; j < end[i]; j++) {
                time[j]++;
            }
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = start[i]; j < end[i]; j++) {
                time[j]--;
            }
            int covered = 0;
            for (int j = 0; j < 1000; j++) {
                if (time[j] > 0) {
                    covered++;
                }
            }
            ans = Math.max(ans, covered);
            for (int j = start[i]; j < end[i]; j++) {
                time[j]++;
            }
        }
        PrintWriter pw = new PrintWriter("lifeguards.out");
        pw.println(ans);
        pw.close();
    }
}
