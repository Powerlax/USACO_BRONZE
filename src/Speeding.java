import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Speeding {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("speeding.in"));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] ndata = new int[n][2];
        int[][] mdata = new int[m][2];
        for (int i = 0; i<n; i++) {
            ndata[i][0] = scanner.nextInt();
            ndata[i][1] = scanner.nextInt();
        }
        for (int i = 0; i<m; i++) {
            mdata[i][0] = scanner.nextInt();
            mdata[i][1] = scanner.nextInt();
        }
        int[] plot = new int[100];
        int count = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<ndata[i][0]; j++) {
                plot[count] = ndata[i][1];
                count++;
            }
        }
        int ans = 0;
        count=0;
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<mdata[i][0]; j++) {
                ans = Math.max(mdata[i][1]-plot[count], ans);
                count++;
            }
        }
        PrintWriter pw = new PrintWriter("speeding.out");
        pw.println(ans);
        pw.close();
    }
}
