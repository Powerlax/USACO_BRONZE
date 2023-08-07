import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MadScientist {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("breedflip.in"));
        int n = scanner.nextInt();
        String a = scanner.next();
        String b = scanner.next();
        int count = 0;
        boolean inFlip = false;
        for (int i = 0; i<n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (!inFlip) {
                    inFlip = true;
                    count++;
                }
            } else {
                inFlip = false;
            }
        }
        PrintWriter pw = new PrintWriter("breedflip.out");
        pw.println(count);
        pw.close();
    }
}
