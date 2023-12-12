import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DontBeLast {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("notlast.in"));
        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i<n; i++) {
            String temp = scanner.next();
            int tempp = scanner.nextInt();
            try {
                map.put(temp, map.get(temp)+tempp);
            } catch (Exception e) {
                map.put(temp, tempp);
            }
        }
        PrintWriter pw = new PrintWriter("notlast.out");
        if (map.size() == 1) {
            pw.println(map.keySet().toArray()[0]);
            pw.close();
            System.exit(0);
        }
        ArrayList<String> toRemove = new ArrayList<>();
        int lowest = Integer.MAX_VALUE;
        for (String k : map.keySet()) {
            if (map.get(k) < lowest) {
                lowest = map.get(k);
            }
        }
        for (String k : map.keySet()) {
            if (map.get(k) == lowest) {
                toRemove.add(k);
            }
        }
        for (String k : toRemove) {
            map.remove(k);
        }
        if (map.isEmpty()) { // all are same lol
            pw.println("Tie");
            pw.close();
            System.exit(0);
        }
        lowest = Integer.MAX_VALUE;
        int count = 0;
        for (String k : map.keySet()) {
            if (map.get(k) < lowest) {
                lowest = map.get(k);
            }
        }
        for (String k : map.keySet()) {
            if (map.get(k) == lowest) {
                count++;
            }
        }
        if (count >= 2) {
            pw.println("Tie");
            pw.close();
            System.exit(0);
        }
        for (String k : map.keySet()) {
            if (map.get(k) == lowest) {
                pw.println(k);
                pw.close();
                System.exit(0);
            }
        }
    }
}
