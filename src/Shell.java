import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("shell.in"));
            int n = scanner.nextInt();
            int[] shellAtPos = new int[3];
            for (int i = 0; i < 3; i++) { shellAtPos[i] = i; }
            int[] counter = new int[3];
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt() - 1;
                int b = scanner.nextInt() - 1;
                int g = scanner.nextInt() - 1;
                int temp = shellAtPos[b];
                shellAtPos[b] = shellAtPos[a];
                shellAtPos[a] = temp;
                counter[shellAtPos[g]]++;
            }
            PrintWriter pw = new PrintWriter("shell.out");
            pw.println(Math.max(counter[0], Math.max(counter[1], counter[2])));
            pw.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}