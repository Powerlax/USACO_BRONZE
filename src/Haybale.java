import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Haybale {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("staking.in"));
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i<k; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            for (int j = start; j<end+1; j++) {
                data[j]++;
            }
        }
        Arrays.sort(data);
        PrintWriter pw = new PrintWriter("staking.out");
        pw.println(data[n/2]);
        pw.close();
    }
}
