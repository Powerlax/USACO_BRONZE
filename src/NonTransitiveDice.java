import java.util.Scanner;

public class NonTransitiveDice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int t = 0; t<n; t++) {
            int[] dice1 = new int[4];
            int[] dice2 = new int[4];
            for (int i = 0; i<4; i++) {
                dice1[i] = scanner.nextInt();
            }
            for (int i = 0; i<4; i++) {
                dice2[i] = scanner.nextInt();
            }
            String ans = "no";
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j < 10; j++) {
                    for (int k = 1; k < 10; k++) {
                        for (int l = 1; l < 10; l++) {
                            int[] dice3 = {i, j, k, l};
                            if (beats(dice1, dice2) && beats(dice2, dice3) && beats(dice3, dice1)) {
                                ans = "yes";
                            }
                            if (beats(dice2, dice1) && beats(dice1, dice3) && beats(dice3, dice2)) {
                                ans = "yes";
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
    static boolean beats(int[] dice1, int[] dice2) {
        int diff = 0;
        for (int x : dice1) {
            for (int y : dice2) {
                diff += Integer.signum(x - y);
            }
        }
        return diff > 0;
    }
}
