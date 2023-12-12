import java.util.ArrayList;
import java.util.Scanner;

public class AC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n];
        int[] t = new int[n];
        for (int i = 0; i<n; i++) p[i] = scanner.nextInt();
        for (int i = 0; i<n; i++) t[i] = scanner.nextInt();
        int ans = 0;
        while (true) {
            int[] diff = new int[n];
            boolean allZero = true;
            for (int i = 0; i<n; i++) {
                diff[i] = p[i]-t[i];
                if (diff[i] != 0) {
                    allZero = false;
                }
            }
            if (allZero) {
                break;
            }
            boolean increase = true;
            boolean broken = false;
            ArrayList<Integer> indexes = new ArrayList<>();
            for (int i = 0; i<n; i++) {
                if (diff[i] != 0 && diff[i] <= -1) {
                    increase = false;
                }
            }
            if (increase) {
                for (int i = 0; i<n; i++) {
                    if (diff[i] >= 1 && !broken) {
                        indexes.add(i);
                    }
                    if (diff[i] <= 0 && !broken && !indexes.isEmpty()) {
                        broken = true;
                    }

                }
            }
            if (!increase) {
                for (int i = 0; i<n; i++) {
                    if (diff[i] != 0 && diff[i] <= -1 && !broken) {
                        indexes.add(i);
                    }
                    if (diff[i] >= 0 && !broken && !indexes.isEmpty()) {
                        broken = true;
                    }

                }
            }

            for (int i:indexes) {
                if (increase) t[i]++;
                else t[i]--;
            }
            ans++;

        }
        System.out.println(ans);

    }
}
