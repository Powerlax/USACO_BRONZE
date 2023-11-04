import java.util.Scanner;

public class Photoshoot2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] original = new int[n];
        int[] expected = new int[n];
        for (int i = 0; i<n; i++) {
            original[i] = scanner.nextInt();
        }
        for (int i = 0; i<n; i++) {
            expected[i] = scanner.nextInt();
        }
        int answer = 0;
        boolean[] moved = new boolean[n + 1];
        int k = 0;
        for (int j = 0; j < n; j++) {
            while (moved[original[k]]) {
                k++;
            }
            if (expected[j] == original[k]) {
                k++;
            } else {
                answer++;
                moved[expected[j]] = true;
            }
        }
        System.out.println(answer);
    }
}
