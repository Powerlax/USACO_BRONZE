import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TamingTheHerd {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("taming.in"));
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i<n; i++) {
            data[i] = scanner.nextInt();
        }
        PrintWriter pw = new PrintWriter("taming.out");
        if (data[0] > 0) {
            pw.println(-1);
            pw.close();
            System.exit(0);
        }
        data[0] = 0;
        int time = -1;
        int requirement = 0;
        int postion = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (time != -1 && data[i] != -1 && data[i] != time) {
                pw.println(-1);
                pw.close();
                System.exit(0);
            }
            if (time == -1) { time = data[i]; }
            if (data[i] == -1) { data[i] = time; }
            if (data[i] == 0) { requirement++; }
            if (data[i] == -1) { postion++; }
            if (time > -1) { time--; }
        }
        int sum = requirement + postion;
        pw.println(requirement + " " + sum);
        pw.close();
    }
}
