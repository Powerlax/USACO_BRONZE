import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class CreatingStrings {
    static String s;
    static List<String> data = new ArrayList<String>();
    static int[] count = new int[26];
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        for (int i = 0; i < s.length(); i++) { count[s.charAt(i) - 'a']++; }
        search("");
        System.out.println(data.size());
        for (String i : data) {
            System.out.println(i);
        }
    }
    static void search(String curr) {
        if (curr.length() == s.length()) {
            data.add(curr);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                count[i]--;
                search(curr + (char)(i + 'a'));
                count[i]++;
            }
        }
    }
}