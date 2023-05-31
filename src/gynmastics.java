import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class gynmastics {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("gymnastics.in"));
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] data = new int[k][n];
            for (int i = 0; i<k; i++) {
                for (int j = 0; j<k; j++) {
                   data[i][j] = scanner.nextInt();
                }
            }
            ArrayList<int[]> pairs = new ArrayList<>();
            for (int j = 0; j<k-1; j++) {
                for (int i = 0; i<n; j++) {

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
