import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessTheAnimal {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("guess.in"));
        int n = scanner.nextInt();
        List<String>[] data = new List[n];
        for (int i = 0; i < n; i++) {
            data[i] = new ArrayList<>();
            scanner.next();
            int w = scanner.nextInt();
            for (int j = 0; j < w; j++) {
                data[i].add(scanner.next());
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int temp = 0;
                for (String c1 : data[i]) {
                    for (String c2 : data[j]) {
                        if (c1.equals(c2)) {
                            temp++;
                            break;
                        }
                    }
                }
                ans = Math.max(ans, temp);
            }
        }
        PrintWriter pw = new PrintWriter("guess.out");
        pw.println(ans+1);
        pw.close();
    }
}
