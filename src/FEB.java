import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

//Doesnt work RN

public class FEB {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        s = scanner.next().toCharArray();

        if (count('F') == n) {
            s[0] = 'E';
        }

        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s[i] != 'F') {
                positions.add(i);
            }
        }

        int ones = positions.get(0) + n - 1 - positions.get(positions.size() - 1);
        int mn = 0;
        int mx = 0;

        int[][] combinations = zip(positions, positions.subList(1,positions.size()-1));
        for (int i = 0; i<combinations.length; i++){
            int a = combinations[i][0];
            int b = combinations[i][1];
            mn += 1;
        }

    }

    public static int count(char thing) {
        int c = 0;
        for (char i : s) {
            if (i == thing) {
                c++;
            }
        }
        return c;
    }
    public static int[][] zip(List<Integer> p1, List<Integer> p2) {
        int n = p2.size();
        int[][] zipped = new int[n][2];
        for (int i = 0; i<n; i++) {
            zipped[i] = new int[] {p1.get(i), p2.get(i)};
        }
        return zipped;
    }
}
