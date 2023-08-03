import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Hoofball {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("hoofball.in"));
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i<n; i++) {
            data[i] = scanner.nextInt();
        }
        Arrays.sort(data);
        int count = 0;
        for (int i = 0; i<n; i++) {
            int i1 = data[i + 1] - data[i];
            if (i == 0) {
                if (i1 <= data[i+2] - data[i+1]) {
                    count++;
                }
            } else {
                int i2 = data[i] - data[i - 1];
                if (i == n-1) {
                    if (i2 <= data[i-1] - data[i-2]) {
                        count++;
                    }
                } else {
                    if (i2 <= i1) {
                        count++;
                    }
                }
            }
        }
        PrintWriter pw = new PrintWriter("hoofball.out");
        pw.println(count);
        pw.close();
    }
}
