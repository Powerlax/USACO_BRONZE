import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CowTip {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("cowtip.in"));
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] data = new int[n][n];
        for (int i = 0; i<n; i++) {
            String temp = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                data[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }
        int count = 0;
        for (int i = n-1; i>=0; i--) {
            for (int j = n-1; j>=0; j--) {
                if (data[i][j] == 1) {
                    count++;
                    for (int k = 0; k<=i; k++) {
                        for (int l = 0; l<=j; l++) {
                            data[k][l] = 1 - data[k][l];
                        }
                    }
                }
            }
        }
        PrintWriter pw = new PrintWriter("cowtip.out");
        pw.println(count);
        pw.close();
    }
}
