import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Teleportation {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("teleport.in"));
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int direct = Math.abs(a-b);
        int teleport = Math.min(Math.abs(x-a), Math.abs(y-a)) + Math.min(Math.abs(x-b), Math.abs(y-b));
        PrintWriter pw = new PrintWriter("teleport.out");
        pw.println(Math.min(direct, teleport));
        pw.close();
    }
}
