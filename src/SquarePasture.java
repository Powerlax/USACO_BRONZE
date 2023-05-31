import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.*;

public class SquarePasture {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("square.in"));
            int rx1 = scanner.nextInt();
            int ry1 = scanner.nextInt();
            int rx2 = scanner.nextInt();
            int ry2 = scanner.nextInt();
            int px1 = scanner.nextInt();
            int py1 = scanner.nextInt();
            int px2 = scanner.nextInt();
            int py2 = scanner.nextInt();
            int x = max(max(rx1,rx2),max(px1,px2))-min(min(rx1,rx2),min(px1,px2));
            int y = max(max(ry1,ry2),max(py1,py2))-min(min(ry1,ry2),min(py1,py2));
            PrintWriter pw = new PrintWriter("square.out");
            pw.println(max(x,y)*max(x,y));
            scanner.close();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
