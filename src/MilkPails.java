import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MilkPails {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pails.in"));
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> solSpace = new ArrayList<>();
        PrintWriter pw = new PrintWriter("pails.out");
        for (int i = 0; i<=(m/x); i++) {
            for (int j = 0; j<=(m/y); j++) {
                int poss = (i*x)+(j*y);
                if (poss<m) {
                    solSpace.add(poss);
                } else if (poss==m) {
                    pw.println(poss);
                    pw.close();
                    System.exit(0);
                }
            }
        }
        pw.println(Collections.max(solSpace));
        pw.close();
    }
}
