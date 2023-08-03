import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ModernArt {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("art.in"));
        int n = scanner.nextInt();
        int[] up = new int[10];
        int[] down = new int[10];
        int[] left = new int[10];
        int[] right = new int[10];
        for (int i = 0; i<=9; i++) {
            left[i] = up[i] = Integer.MAX_VALUE;
            right[i] = down[i] = -1;
        }
        boolean[] validStart = new boolean[10];
        int[][] art = new int[n][n];
        for (int r = 0; r < n; r++) {
            String row = scanner.nextLine();
            for (int c = 0; c < n; c++) {
                int curr = Character.getNumericValue(row.charAt(c));
                art[r][c] = curr;
                if (curr != 0) {
                    left[curr] = Math.min(left[curr], c);
                    right[curr] = Math.max(right[curr], c);
                    down[curr] = Math.max(down[curr], r);
                    up[curr] = Math.min(up[curr], r);
                    validStart[curr] = true;
                }
            }
        }
        for (int color = 1; color <= 9; color++) {
            for (int r = up[color]; r <= down[color]; r++) {
                for (int c = left[color]; c <= right[color]; c++) {
                    if (art[r][c] != color) { validStart[art[r][c]] = false; }
                }
            }
        }
        int ans = 0;
        for (boolean c : validStart) {
            ans += c ? 1 : 0;
        }
        PrintWriter pw = new PrintWriter("art.out");
        pw.println(ans);
        pw.close();
    }
}
