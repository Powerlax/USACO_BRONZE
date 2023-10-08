import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WhereAmI {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("whereami.in"));
        int n = scanner.nextInt();
        String data = scanner.next();
        for (int k = 1; k<n; k++) {
            String part = data.substring(0, k);
            if (data.lastIndexOf(part) > 0) {
                PrintWriter pw = new PrintWriter("whereami.out");
                pw.println(k+1);
                pw.close();
            }
        }
    }
}
