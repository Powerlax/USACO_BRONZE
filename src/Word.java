import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("word.in"));
            int k = scanner.nextInt();
            scanner.nextLine();
            String[] words = scanner.nextLine().split(" ");
            PrintWriter pw = new PrintWriter("word.out");

            int length = 0;
            ArrayList<String> line = new ArrayList<>();
            for (String word:words) {
                if ((word.length()+length)<=k) {
                    length += word.length();
                    line.add(word);
                } else {
                    pw.println(String.join(" ", line));
                    line.clear();
                    line.add(word);
                    length = word.length();

                }
            }
            pw.println(String.join(" ", line));
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
