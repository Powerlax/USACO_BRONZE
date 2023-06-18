import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Censor {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("censor.in"));
            String S = scanner.nextLine();
            StringBuilder out = new StringBuilder();
            String T = scanner.nextLine();
            for (int i = 0; i < S.length(); i++) {
                out.append(S.substring(i, i + 1));
                if ((out.length() >= T.length()) && out.substring(out.length() - T.length()).contentEquals(T)) {
                    out.delete(out.length() - T.length(), out.length());
                }
            }
            PrintWriter pw = new PrintWriter("censor.out");
            pw.println(out);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
