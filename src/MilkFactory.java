import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MilkFactory {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("factory.in"));
        ArrayList<Integer> nodes = new ArrayList<>();
        int n = scanner.nextInt();
        int[][] graph = new int[n-1][2];
        for (int i = 0; i < n-1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph[i][0] = x;
            graph[i][1] = y;
            if (!nodes.contains(x)) {
                nodes.add(x);
            }
            if (!nodes.contains(y)) {
                nodes.add(y);
            }
        }
        int ans = -1;
        for (Integer node : nodes) {
            int count = 0;
            for (int j = 0; j < n - 1; j++) {
                if (graph[j][1] == node) {
                    count++;
                }
            }
            if (count == n - 1) {
                ans = node;
                break;
            }
        }
        PrintWriter pw = new PrintWriter("factory.out");
        pw.println(ans);
        pw.close();
    }
}
