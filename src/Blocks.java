import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Blocks {
    static final char[][] blocks = new char[4][];
    static final Set<String> makeable = new HashSet<>();

    static void recur(int usedMask, String word) {
        makeable.add(word);
        for (int j = 0; j < 4; j++) {
            if ((usedMask & (1 << j)) == 0) {
                for (char letter : blocks[j]) {
                    recur(usedMask + (1 << j), word + letter);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for (int j = 0; j < 4; j++) {
            blocks[j] = in.readLine().toCharArray();
        }
        recur(0, "");
        StringBuilder out = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (makeable.contains(in.readLine())) {
                out.append("YES");
            } else {
                out.append("NO");
            }
            out.append('\n');
        }
        System.out.print(out);
    }
}