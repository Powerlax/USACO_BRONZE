import java.io.*;
import java.util.*;

public class ChessboardQueens {
    static final int DIM = 8;
    static boolean[][] block = new boolean[DIM][DIM];
    static final List<Integer> queens = new ArrayList<>();
    static final boolean[] chosen = new boolean[DIM];
    static int validNum = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        for (int r = 0; r < DIM; r++) {
            String row = read.readLine();
            for (int c = 0; c < DIM; c++) {
                if (row.charAt(c) == '*') { block[r][c] = true; }
            }
        }
        genQueens();
        System.out.println(validNum);
    }
    private static void genQueens() {
        if (queens.size() == DIM) {
            boolean works = true;
            for (int c = 0; c < DIM; c++) {
                if (block[queens.get(c)][c]) {
                    works = false;
                    break;
                }
            }
            boolean[] taken = new boolean[DIM * 2 - 1];
            for (int c = 0; c < DIM; c++) {
                if (taken[c + queens.get(c)]) {
                    works = false;
                    break;
                }
                taken[c + queens.get(c)] = true;
            }
            taken = new boolean[DIM * 2 - 1];
            for (int c = 0; c < DIM; c++) {
                // queens.get(c) - c can be negative; the DIM - 1 offsets that
                if (taken[queens.get(c) - c + DIM - 1]) {
                    works = false;
                    break;
                }
                taken[queens.get(c) - c + DIM - 1] = true;
            }
            if (works) {
                validNum++;
            }
        } else {
            for (int c = 0; c < DIM; c++) {
                if (chosen[c]) { continue; }
                chosen[c] = true;
                queens.add(c);
                genQueens();
                chosen[c] = false;
                queens.remove(queens.size() - 1);
            }
        }
    }
}