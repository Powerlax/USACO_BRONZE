import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Billboard2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("billboard.in"));
            boolean[][] view = new boolean[2000][2000];
            int[] b1 = new int[4]; //lawn
            int[] b2 = new int[4];
            for (int i = 0; i<4; i++) {
                b1[i] = scanner.nextInt();
                b1[i] += 1000; //making fit our array
            }
            for (int i = 0; i<4; i++) {
                b2[i] = scanner.nextInt();
                b2[i] += 1000;
            }
            for (int i = b1[1]; i<b1[3]; i++) {
                for (int j = b1[0]; j<b1[2]; j++) {
                    view[i][j] = true;
                }
            }
            for (int i = b2[1]; i<b2[3]; i++) {
                for (int j = b2[0]; j<b2[2]; j++) {
                    view[i][j] = false;
                }
            }
            int left = min(b1[0], b2[0]); //selecting interesting parts
            int right = max(b1[2], b2[2]);
            int up = max(b1[3],b2[3]);
            int down = min(b1[1], b2[1]);
            ArrayList<Integer> xcount = new ArrayList<>();
            ArrayList<Integer> ycount = new ArrayList<>();
            for (int i = down; i<up; i++) {
                for (int j = left; j<right; j++) {
                    if (view[i][j]) {
                        xcount.add(i);
                        break;
                    }
                }
            }
            for (int i = left; i<right; i++) {
                for (int j = down; j<up; j++) {
                    if (view[j][i]) {
                        ycount.add(i);
                        break;
                    }
                }
            }
            int ans;
            if (xcount.size()==0 || ycount.size()==0) {
                ans = 0;
            } else {
                int x = xcount.get(xcount.size()-1)-xcount.get(0)+1;
                int y = ycount.get(ycount.size()-1)-ycount.get(0)+1;
                ans = x*y;
            }
            PrintWriter pw = new PrintWriter("billboard.out");
            pw.println(ans);
            pw.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
