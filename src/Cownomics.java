import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cownomics {
    public static int n;
    public static int m;
    public static String[] spotted;
    public static String[] plain;
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("cownomics.in"));
            String tempppp = scanner.nextLine();
            n = Integer.parseInt(String.valueOf(tempppp.charAt(0)));
            m = Integer.parseInt(String.valueOf(tempppp.charAt(2)));
            spotted = new String[n];
            plain = new String[n];
            for (int i = 0; i < n; i++) {
                spotted[i] = scanner.nextLine();
            }
            for (int i = 0; i < n; i++) {
                plain[i] = scanner.nextLine();
            }
            int count = 0;
            for (int j = 0; j < m; j++) {
               if (test_loc(j)) {
                   count++;
               }
            }

            PrintWriter pw = new PrintWriter("cownomics.out");
            pw.println(count);
            pw.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean test_loc(int j) {
        boolean[][] cows = new boolean[2][4];
        for (int i = 0; i<n; i++) {
            if (spotted[i].charAt(j) == 'A') cows[0][0] = true;
            if (spotted[i].charAt(j) == 'G') cows[0][1] = true;
            if (spotted[i].charAt(j) == 'T') cows[0][2] = true;
            if (spotted[i].charAt(j) == 'C') cows[0][3] = true;
        }
        for (int i = 0; i<n; i++) {
            if (plain[i].charAt(j) == 'A') cows[1][0] = true;
            if (plain[i].charAt(j) == 'G') cows[1][1] = true;
            if (plain[i].charAt(j) == 'T') cows[1][2] = true;
            if (plain[i].charAt(j) == 'C') cows[1][3] = true;
        }
        for (int i = 0; i<4; i++) {
            if (cows[0][i] && cows[1][i]) return false;
        }
        return true;
    }
}
