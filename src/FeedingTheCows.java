import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FeedingTheCows {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(in.readLine());
        for (int t = 0; t < testCases; t++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());
            char[] cows = in.readLine().toCharArray();
            calculatePatches(cows, n, k);
        }
    }
    private static void calculatePatches(char[] cows, int n, int k) {
        char[] answer = new char[n];
        for (int j = 0; j < n; j++) {
            answer[j] = '.';
        }
        int lastGuernseyPatch = -k - 1;
        int lastHolsteinPatch = -k - 1;
        int amtPatches = 0;
        for (int j = k; j < n; j++) {
            if (cows[j - k] == 'G') {
                if ((j - k) - lastGuernseyPatch > k) {
                    amtPatches++;
                    answer[j] = 'G';
                    lastGuernseyPatch = j;
                }
            } else {
                if ((j - k) - lastHolsteinPatch > k) {
                    amtPatches++;
                    answer[j] = 'H';
                    lastHolsteinPatch = j;
                }
            }
        }
        boolean gNeeds = checkNeedForPatch('G', cows, n, lastGuernseyPatch, k);
        boolean hNeeds = checkNeedForPatch('H', cows, n, lastHolsteinPatch, k);
        if (gNeeds || hNeeds) {
            for (int j = n - 1; j >= 0; j--) {
                if (answer[j] == '.') {
                    amtPatches++;
                    answer[j] = gNeeds ? 'G' : 'H';
                    break;
                }
            }
        }
        System.out.println(amtPatches);
        System.out.println(answer);
    }
    private static boolean checkNeedForPatch(char cowType, char[] cows, int n, int lastPatch, int k) {
        for (int j = n - 1; j >= 0; j--) {
            if (cows[j] == cowType && j - lastPatch > k) {
                return true;
            }
        }
        return false;
    }
}
