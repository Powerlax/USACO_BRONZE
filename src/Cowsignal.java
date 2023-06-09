import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cowsignal {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("cowsignal.in"));
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            scanner.nextLine();
            String[] sheet = new String[m];
            for (int i = 0; i < m; i++) {
                sheet[i] = scanner.nextLine();
            }
            for (int i = 0; i < m; i++) {
                sheet[i] = multiply(sheet[i], k);
            }
            sheet = multiply(sheet, k);
            PrintWriter pw = new PrintWriter("cowsignal.out");
            for (String s:sheet) {
                pw.println(s);
            }
            pw.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String multiply (String a, int k){
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i<a.length(); i++) {
            for (int j = 0; j<k; j++) {
                ans.append(a.charAt(i));
            }
        }
        return ans.toString();
    }
    public static String[] multiply (String[] sheet, int k) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i< sheet.length; i++) {
            for (int j = 0; j<k; j++) {
                ans.add(sheet[i]);
            }
        }
        String[] result = new String[ans.size()];
        for (int i = 0; i< ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}
