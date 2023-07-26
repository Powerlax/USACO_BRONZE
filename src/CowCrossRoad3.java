import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class CowCrossRoad3 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("cowqueue.in"));
        int n = scanner.nextInt();
        int[][] data = new int[n][2];
        for (int i = 0; i<n; i++) {
            data[i][0] = scanner.nextInt();
            data[i][1] = scanner.nextInt();
        }
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n-1; j++) {
                if (data[j][0]>data[j+1][0]) {
                    int[] temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        int time = 0;
        for (int i = 0; i<n; i++) {
            if (time < data[i][0]) {
                time = data[i][0];
            }
            time += data[i][1];
        }

        PrintWriter pw = new PrintWriter("cowqueue.out");
        pw.println(time);
        pw.close();
    }
}
