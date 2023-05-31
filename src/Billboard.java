import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;
import java.lang.System;


public class Billboard {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("billboard.in"));
            Scanner scanner1 = new Scanner(System.in);
            boolean[][] view = new boolean[2000][2000];
            int[] b1 = new int[4];
            int[] b2 = new int[4];
            int[] t = new int[4];
            for (int i = 0; i<4; i++) {
                b1[i] = scanner.nextInt();
                b1[i] += 1000; //making fit our array
            }
            for (int i = 0; i<4; i++) {
                b2[i] = scanner.nextInt();
                b2[i] += 1000;
            }
            for (int i = 0; i<4; i++) {
                t[i] = scanner.nextInt();
                t[i] += 1000;
            }
            for (int i = b1[1]; i<b1[3]; i++) {
                for (int j = b1[0]; j<b1[2]; j++) {
                    view[i][j] = true;
                }
            }
            for (int i = b2[1]; i<b2[3]; i++) {
                for (int j = b2[0]; j<b2[2]; j++) {
                    view[i][j] = true;
                }
            }
            for (int i = t[1]; i<t[3]; i++) {
                for (int j = t[0]; j<t[2]; j++) {
                    view[i][j] = false;
                }
            }
            int left = min(b1[0], min(b2[0], t[0])); //selecting interesting parts
            int right = max(b1[2], max(b2[2], t[2]));
            int up = max(b1[3], max(b2[3], t[3]));
            int down = min(b1[1], min(b2[1], t[1]));
            int count = 0;
            for (int i = down; i<up; i++) {
                for (int j = left; j<right; j++) {
                    if (view[i][j]) {
                        count++;
                    }
                }
            }
            PrintWriter pw = new PrintWriter("billboard.out");
            pw.println(count);
            pw.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
