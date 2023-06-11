import java.io.*;
import java.util.Scanner;

public class Traffic {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("traffic.in"));
            int numMiles = scanner.nextInt();
            String[] segmentType = new String[numMiles];
            int[] start = new int[numMiles];
            int[] end = new int[numMiles];
            for (int m = 0; m < numMiles; m++) {
                segmentType[m] = scanner.next();
                start[m] = scanner.nextInt();
                end[m] = scanner.nextInt();
            }
            int low = -(int) 1e9;
            int high = (int) 1e9;
            for (int m = numMiles - 1; m >= 0; m--) {
                if (segmentType[m].equals("none")) {
                    low = Math.max(low, start[m]);
                    high = Math.min(high, end[m]);
                } else if (segmentType[m].equals("off")) {
                    low += start[m];
                    high += end[m];
                } else if (segmentType[m].equals("on")) {
                    low -= end[m];
                    high -= start[m];
                    low = Math.max(0, low);
                }
            }
            PrintWriter pw = new PrintWriter("traffic.out");
            pw.println(low + " " + high);
            low = -(int) 1e9;
            high = (int) 1e9;
            for (int m = 0; m < numMiles; m++) {
                if (segmentType[m].equals("none")) {
                    low = Math.max(low, start[m]);
                    high = Math.min(high, end[m]);
                } else if (segmentType[m].equals("on")) {
                    low += start[m];
                    high += end[m];
                } else if (segmentType[m].equals("off")) {
                    low -= end[m];
                    high -= start[m];
                    low = Math.max(0, low);
                }
            }
            pw.println(low + " " + high);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}