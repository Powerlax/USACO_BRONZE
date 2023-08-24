import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SwapitySwap {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("swap.in"));
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int b2 = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i<n; i++) {
            data[i] = i+1;
        }
        int[] cycle = new int[n];
        for (int i = 0; i<n; i++) {
            int pos = i;
            int count = 0;
            while (true) {
                pos = (pos+1)%n;
                count++;
                if (pos == i) {
                    break;
                }
            }
            cycle[i] = count;
        }
        int[] finalPos = new int[n];
        for (int i = 0; i<n; i++) {
            int pos = i;
            for (int j = 0; j<k%cycle[i]; j++) {
                if (pos >= a1-1 && pos <= a2-1) {
                    pos = a1-1 + a2-1 - pos;
                } else if (pos >= b1-1 && pos <= b2-1) {
                    pos = b1-1 + b2-1 - pos;
                }
            }
            finalPos[i] = pos;
        }
        int[] finalPerm = new int[n];
        for (int i = 0; i<n; i++) {
            finalPerm[finalPos[i]] = data[i];
        }
        PrintWriter pw = new PrintWriter("swap.out");
        for (int i = 0; i<n; i++) {
            pw.println(finalPerm[i]);
        }
        pw.close();
    }
}
