import java.io.*;
import java.util.*;

public class Cownomics {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("cownomics.in"));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] spottedCows = new char[n][m];
        char[][] plainCows = new char[n][m];
        for (int i = 0; i < n; i++) {
            spottedCows[i] = scanner.next().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            plainCows[i] = scanner.next().toCharArray();
        }
        int ans = 0;
        boolean dupe;
        for (int i = 0; i < m; i++) {
            dupe = false;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (spottedCows[j][i] == plainCows[k][i]) {
                        dupe = true;
                        break;
                    }
                }
            }
            if (!dupe) {
                ans++;
            }
        }
        PrintWriter pw = new PrintWriter("cownomics.out");
        pw.println(ans);
        pw.close();
    }
}