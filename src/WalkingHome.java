import java.util.Scanner;

public class WalkingHome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int z = 0; z<t; z++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int ans = 0;
            char[][] data = new char[n][n];
            for (int j = 0; j<n; j++) {
                data[j] = scanner.next().toCharArray();
            }
            if (k>=1) {
                int ur = 1;
                int dl = 1;
                for(int l = 0; l < n; l++) {
                    if(data[0][l] == 'H' || data[l][n-1] == 'H') ur = 0;
                    if(data[l][0] == 'H' || data[n-1][l] == 'H') dl = 0;
                }
                ans += (dl + ur);
            }
            if (k>=2) {
                for(int j = 1; j < n-1; j++) {
                    boolean valid = true;
                    for(int i = 0; i < n; i++) {
                        if(data[i][j] == 'H') valid = false;
                        if(i < j && data[0][i] == 'H') valid = false;
                        if(i > j && data[n-1][i] == 'H') valid = false;
                    }
                    if (valid) ans++;
                }
                for(int i = 1; i < n-1; i++) {
                    boolean valid = true;
                    for(int j = 0; j < n; j++) {
                        if(data[i][j] == 'H') valid = false;
                        if(j < i && data[j][0] == 'H') valid = false;
                        if(j > i && data[j][n-1] == 'H') valid = false;
                    }
                    if (valid) ans++;
                }
            }
            if (k>=3) {
                for(int i = 1; i < n-1; i++) {
                    for(int j = 1; j < n-1; j++) {
                        boolean valid = data[i][j] == '.';
                        for(int a = 0; a < n; a++) {
                            if(a <= i && data[a][j] == 'H') valid = false;
                            if(a >= i && data[a][n-1] == 'H') valid = false;
                            if(a <= j && data[0][a] == 'H') valid = false;
                            if(a >= j && data[i][a] == 'H') valid = false;
                        }
                        if (valid) ans++;
                        valid = data[i][j] == '.';
                        for(int a = 0; a < n; a++) {
                            if(a <= i && data[a][0] == 'H') valid = false;
                            if(a >= i && data[a][j] == 'H') valid = false;
                            if(a <= j && data[i][a] == 'H') valid = false;
                            if(a >= j && data[n-1][a] == 'H') valid = false;
                        }
                        if (valid) ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
