import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lineup {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("lineup.in"));
        int n = scanner.nextInt();
        String[] cows1 = {"Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
        ArrayList<String> cows = new ArrayList<>(Arrays.asList(cows1));
        String[][] pairs = new String[n][2];
        for (int i = 0; i<n; i++) {
            pairs[i][0] = scanner.next();
            for (int j = 0; j<4; j++) {
                scanner.next();
            }
            pairs[i][1] = scanner.next();
        }
        ArrayList<String> ans = new ArrayList<>();
        ans.add("Beatrice");
        boolean yes;
        for (int i = 0; i<6; i++) {
            yes = true;
            for (int j=0; j<n; j++) {
                if (pairs[j][0].equals(ans.get(i))&&!ans.contains(pairs[j][1])) {
                    ans.add(pairs[j][1]);
                    cows.remove(pairs[j][1]);
                    yes = false;
                } if (pairs[j][1].equals(ans.get(i))&&!ans.contains(pairs[j][0])) {
                    ans.add(pairs[j][0]);
                    cows.remove(pairs[j][0]);
                    yes = false;
                }
            }
            if (yes) {
                ans.add(cows.get(0));
                cows.remove(0);
            }
        }
        PrintWriter pw = new PrintWriter("lineup.out");
        for (String i : ans) {
            pw.println(i);
        }
        pw.close();
    }
}
