import java.io.*;
import java.util.*;
public class ContaminatedMilk {
    static int[] personDrink;
    static int[] milkDrink;
    static int[] timeDrink;
    static int[] personSick;
    static int[] timeSick;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("badmilk.in"));
        scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        int s = scanner.nextInt();
        personDrink = new int[d];
        milkDrink = new int[d];
        timeDrink = new int[d];
        personSick = new int[s];
        timeSick = new int[s];
        for (int i = 0; i < d; i++) {
            personDrink[i] = scanner.nextInt();
            milkDrink[i] = scanner.nextInt();
            timeDrink[i] = scanner.nextInt();
        }
        for (int i = 0; i < s; i++) {
            personSick[i] = scanner.nextInt();
            timeSick[i] = scanner.nextInt();
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            if (milkTypeCanBeBad(i)) {
                int numDrank = numPeopleDrink(i);
                if (numDrank > ans) {
                    ans = numDrank;
                }
            }
        }
        PrintWriter pw = new PrintWriter("badmilk.out");
        pw.println(ans);
        pw.close();
    }
    public static boolean milkTypeCanBeBad(int milkType) {
        for (int i = 0; i < personSick.length; i++) {
            if (!personDrankMilkBefore(personSick[i], milkType, timeSick[i])) {
                return false;
            }
        }
        return true;
    }
    private static boolean personDrankMilkBefore(int person, int milkType, int time) {
        for (int i = 0; i < personDrink.length; i++) {
            if (personDrink[i] == person && milkDrink[i] == milkType &&
                    timeDrink[i] < time) {
                return true;
            }
        }
        return false;
    }
    private static int numPeopleDrink(int milkType) {
        boolean[] didDrink = new boolean[51];
        for (int i = 0; i < personDrink.length; i++) {
            if (milkDrink[i] == milkType) {
                didDrink[personDrink[i]] = true;
            }
        }
        int numPeopleDrink = 0;
        for (int i = 1; i < didDrink.length; i++) {
            if (didDrink[i]) { numPeopleDrink++; }
        }
        return numPeopleDrink;
    }
}