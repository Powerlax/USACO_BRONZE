import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class MixMilk {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("mixmilk.in"));
            int[] bucket = new int[3];
            int[] milk = new int[3];
            for (int i = 0; i<3; i++) {
                bucket[i] = scanner.nextInt();
                milk[i] = scanner.nextInt();
            }

            for (int i = 0; i<100; i++) {
                int x = i%3;
                int y = (i+1)%3;
                int m1 = milk[x];
                int b2 = bucket[y];
                int m2 = milk[y];
                m2 += m1;
                m1 = 0;
                if (m2 > b2) {
                    m1 = m2 - b2;
                    m2 = b2;
                }
                milk[x] = m1;
                milk[y] = m2;
            }

            PrintWriter pw = new PrintWriter(new File("mixmilk.out"));
            for (int i : milk) {
                pw.println(i);
            }
            pw.close();
            scanner.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
