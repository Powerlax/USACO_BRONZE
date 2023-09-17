import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseEngineering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine();
            List<String> data = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                data.add(scanner.nextLine());
            }
            while (true) {
                int oldSize = data.size();
                for (int k = 0; k < n; k++) {
                    for (char bit = '0'; bit <= '1'; bit++) {
                        int pos = 0;
                        for (String dp : data) {
                            if (dp.charAt(k) == bit) {
                                pos |= 1 << (dp.charAt(n + 1) - '0');
                            }
                        }
                        if (pos != 3) {
                            int K = k;
                            char Bit = bit;
                            data.removeIf(dp -> dp.charAt(K) == Bit);
                        }
                    }
                }
                int newSize = data.size();
                if (newSize == oldSize) {
                    break;
                }
            }
            if (data.isEmpty()) {
                System.out.println("OK");
            } else {
                System.out.println("LIE");
            }
        }
    }
}