import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Herdle {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String correct = in.readLine() + in.readLine() + in.readLine();
        String guess = in.readLine() + in.readLine() + in.readLine();
        int[] freqCorrect = new int[26];
        int[] freqGuess = new int[26];
        int green = 0;
        for (int j = 0; j < 9; j++) {
            if (correct.charAt(j) == guess.charAt(j)) {
                green++;
            }
            freqCorrect[correct.charAt(j) - 'A']++;
            freqGuess[guess.charAt(j) - 'A']++;
        }
        int yellow = 0;
        for (int j = 0; j < 26; j++) {
            yellow += Math.min(freqCorrect[j], freqGuess[j]);
        }
        yellow -= green;
        System.out.println(green);
        System.out.println(yellow);
    }
}