import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Revegetation {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("revegetate.in"));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[151];
        int[] b = new int[151];
        int[] c = new int[101];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            if (a[i] > b[i]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
        }
        PrintWriter pw = new PrintWriter("revegetate.out");
        for (int i = 1; i <= n; i++) {
            int g;
            for (g = 1; g <= 4; g++) {
                boolean ok = true;
                for (int j = 0; j < m; j++) {
                    if (b[j] == i && c[a[j]] == g) {
                        ok = false;
                    }
                }
                if (ok) {
                    break;
                }
            }
            c[i] = g;
            pw.print(g);
        }
        pw.close();
    }
}
