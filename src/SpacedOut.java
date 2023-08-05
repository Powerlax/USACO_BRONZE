import java.util.Scanner;

public class SpacedOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] data = new int[n][n];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
        int rowsAlternate = 0, colsAlternate = 0;
        for (int i = 0; i < n; i++) {
            int[] sum = new int[2];
            for (int j = 0; j < n; j++) {
                sum[j % 2] += data[i][j];
            }
            rowsAlternate += Math.max(sum[0], sum[1]);
        }
        for (int i = 0; i < n; i++) {
            int[] sum = new int[2];
            for (int j = 0; j < n; j++) { sum[j % 2] += data[j][i]; }
            colsAlternate += Math.max(sum[0], sum[1]);
        }
        System.out.println(Math.max(rowsAlternate, colsAlternate));
    }
}
