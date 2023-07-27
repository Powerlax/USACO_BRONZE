import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PromotionCounting {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("promote.in"));
        int[] before = new int[4];
        int[] after = new int[4];
        for (int i = 0; i<4; i++) {
            before[i] = scanner.nextInt();
            after[i] = scanner.nextInt();
        }
        int GtoP = after[3] - before[3];
        int StoG = after[2] - (before[2] + GtoP);
        int BtoS = after[1] - (before[1] + StoG);
        PrintWriter pw = new PrintWriter("promote.out");
        pw.println(BtoS);
        pw.println(StoG);
        pw.println(GtoP);
        pw.close();
    }
}
