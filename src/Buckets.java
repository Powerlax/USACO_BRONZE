import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Buckets {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("buckets.in"));
            String temp;
            int[] lake = new int[2];
            int[] barn = new int[2];
            int[] rock = new int[2];
            for (int i = 0; i<10; i++) {
                temp = scanner.nextLine();
                for (int j = 0; j<10; j++) {
                    if (temp.charAt(j)=='L') {
                        lake[0] = i;
                        lake[1] = j;
                    }
                    if (temp.charAt(j)=='B') {
                        barn[0] = i;
                        barn[1] = j;
                    }
                    if (temp.charAt(j)=='R') {
                        rock[0] = i;
                        rock[1] = j;
                    }
                }
            }
            PrintWriter pw = new PrintWriter("buckets.out");
            int ans = (Math.abs(lake[0]-barn[0]))+(Math.abs(lake[1]-barn[1]))-1;
            if (((barn[0] == lake[0] && barn[0] == rock[0]) && ((lake[1]<rock[1]&&rock[1]<barn[1]) || (lake[1]>rock[1]&&rock[1]>barn[1])))
                    || ((barn[1] == lake[1] && barn[1] == rock[1]) && ((lake[0]<rock[0]&&rock[0]<barn[0]) || (lake[0]>rock[0]&&rock[0]>barn[0])))) {
                ans += 2;
            }
            pw.println(ans);
            pw.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
