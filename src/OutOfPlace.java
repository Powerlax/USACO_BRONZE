import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class OutOfPlace {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("outofplace.in"));
        int n = scanner.nextInt();
        int[] data = new int[n+1];
        for (int i = 0; i<n; i++) {
            data[i] = scanner.nextInt();
        }
        data[n] = -1000000;
        int pos = -1;
        boolean yes = true;
        for (int i = 0; i<n; i++) {
            if (data[i] > data[i+1]) {
                pos = i;
                break;
            }
        }
        int correct = -1;
        for (int i = 0; i<n; i++) {
            if (data[i] > data[pos]) {
                correct = i;
                break;
            }
        }
        PrintWriter pw = new PrintWriter("outofplace.out");
        if (pos > correct) {
            System.out.println(pos);
            System.out.println(correct);
            pw.println((pos-correct)-1);
        } else {
            pw.println((correct-pos)-1);
        }
        pw.close();

    }
}
