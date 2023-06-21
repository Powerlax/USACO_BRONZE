import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Gymnastics {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("gymnastics.in"));
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] data = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
        ArrayList<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < k-1; i++) {
            for (int j = i+1; j < k; j++) {
                int[] temp = {data[0][i], data[0][j]};
                pairs.add(temp);
            }
        }
        int ans = 0;
        for (int[] pair : pairs) {
            boolean bad = false;
            for (int i = 0; i<n; i++) {
                if (find(data[i],pair[0]) > find(data[i],pair[1])) {
                    bad = true;
                    break;
                }
            }
            if (!bad) {
                ans++;
            }
        }
        PrintWriter pw = new PrintWriter("gymnastics.out");
        pw.println(ans);
        pw.close();
    }
    public static int find(int[] arr, int target) {
        for (int i = 0; i<arr.length; i++) {
            if (target==arr[i]) {
                return i;
            }
        }
        return -1;
    }
}



