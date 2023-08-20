import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GrassPlanting {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("planting.in"));
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i<n-1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            data[a-1]++;
            data[b-1]++;
        }
        int ans = 0;
        for (int i = 0; i<n; i++) {
            if (data[i] > ans) {
                ans = data[i];
            }
        }
        ans++;
        PrintWriter pw = new PrintWriter("planting.out");
        pw.println(ans);
        pw.close();
    }
}
