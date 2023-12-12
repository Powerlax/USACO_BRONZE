import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LostCow {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("lostcow.in"));
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        boolean greater = x > y;
        int total = 0;
        int curr = 1;
        int currLast = 0;
        while (true) {
            total += Math.abs(curr)+Math.abs(currLast);
            if (greater) {
                if (curr+x <= y) {
                    total -= Math.abs((curr+x)-y);
                    break;
                }
            } else {
                if (curr+x >= y) {
                    total -= Math.abs((curr+x)-y);
                    break;
                }
            }
            currLast = curr;
            curr *= -2;
        }
        PrintWriter pw = new PrintWriter("lostcow.out");
        pw.println(total);
        pw.close();
    }
}
