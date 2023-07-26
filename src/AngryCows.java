import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class AngryCows {
    static int[] data;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("angry.in"));
        int n = scanner.nextInt();
        data = new int[n];
        for (int i = 0; i<n; i++) {
            data[i] = scanner.nextInt();
        }
        int ans = 0;
        for (int i = 0; i<n; i++) {
            Math.max(ans, simulate(1, data[i])); //our recursive function
        }
        PrintWriter pw = new PrintWriter("angry.out");
        pw.println(ans);
        pw.close();
    }
    public static int simulate(int blastRadius, int position_to_calculate) {
        int ans = 0;
        for (int i = 0; i<data.length; i++) {
            if (data[i] >= position_to_calculate && data[i] <= position_to_calculate + blastRadius) {
                ans++;
            }
        }
        if (ans == 0) {
            return 0;
        }
        return Math.max(ans, simulate(blastRadius + 1, position_to_calculate));
    }
}
