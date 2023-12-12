import java.util.Scanner;

public class StampGrid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            scanner.nextLine();
            scanner.nextLine();
            int N = scanner.nextInt();
            char[][] grid = new char[N][N];
            for (int i = 0; i < N; i++) {
                grid[i] = scanner.next().toCharArray();
            }
            int K = scanner.nextInt();
            char[][] stamp = new char[K][K];
            for (int i = 0; i < K; i++) {
                stamp[i] = scanner.next().toCharArray();
            }
            char[][] ans = new char[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ans[i][j] = '.';
                }
            }
            for (int rot = 0; rot < 4; rot++) {
                for (int i = 0; i < N - K + 1; i++) {
                    for (int j = 0; j < N - K + 1; j++) {
                        boolean valid = true;
                        for (int a = 0; a < K; a++) {
                            for (int b = 0; b < K; b++) {
                                if (!(grid[i + a][j + b] == '*' || stamp[a][b] == '.')) {
                                    valid = false;
                                    break;
                                }
                            }
                            if (!valid) {
                                break;
                            }
                        }
                        if (valid) {
                            for (int a = 0; a < K; a++) {
                                for (int b = 0; b < K; b++) {
                                    if (stamp[a][b] == '*') {
                                        ans[i + a][j + b] = '*';
                                    }
                                }
                            }
                        }
                    }
                }
                char[][] newStamp = new char[K][K];
                for (int i = 0; i < K; i++) {
                    for (int j = 0; j < K; j++) {
                        newStamp[i][j] = stamp[K - 1 - j][i];
                    }
                }
                stamp = newStamp;
            }
            boolean isEqual = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] != ans[i][j]) {
                        isEqual = false;
                        break;
                    }
                }
                if (!isEqual) {
                    break;
                }
            }
            System.out.println(isEqual ? "YES" : "NO");
        }
        scanner.close();
    }
}
