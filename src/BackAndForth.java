import java.io.*;
import java.util.*;

public class BackAndForth {
    static HashSet<Integer> possible = new HashSet<Integer>();
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("backforth.in"));
        PrintWriter pw = new PrintWriter("backforth.out");
        ArrayList<Integer> bHere = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            bHere.add(scanner.nextInt());
        }
        ArrayList<Integer> bThere = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            bThere.add(scanner.nextInt());
        }
        solve(4, bHere, bThere, 1000, 1000);
        pw.println(possible.size());
        pw.close();
    }

    public static void solve(int trips_left, ArrayList<Integer> bHere, ArrayList<Integer> bThere, int tHere, int tThere) {
        if (trips_left == 0) {
            possible.add(tHere);
        } else {
            for (int i = 0; i < bHere.size();
                 i++) {
                int bucket = bHere.get(i);
                ArrayList<Integer> new_buckets_dest = new ArrayList<Integer>(bThere);
                new_buckets_dest.add(bucket);
                ArrayList<Integer> new_buckets_src = new ArrayList<Integer>();
                for (int j = 0; j < bHere.size(); j++) {
                    if (i != j) {
                        new_buckets_src.add(bHere.get(j));
                    }
                }
                int new_tank_dest = tThere + bucket;
                int new_tank_src = tHere - bucket;
                solve(trips_left - 1, new_buckets_dest, new_buckets_src,
                        new_tank_dest, new_tank_src);
            }
        }
    }
}