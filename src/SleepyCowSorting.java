import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SleepyCowSorting {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("sleepy.in"));
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i<n; i++) {
            data[i] = scanner.nextInt();
        }
        int index = 0;
        for (int i = n-1; i>0; i--) {
            if (data[i]<data[i-1]) {
                index = i;
                break;
            }
        }
        PrintWriter pw = new PrintWriter("sleepy.out");
        pw.println(index);
        pw.close();

    }
}
