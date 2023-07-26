import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class TeamTicTacToe {
    public static void main(String[] args) throws Exception{
        char[][] board = new char[3][3];
        Scanner scanner = new Scanner(new File("tttt.in"));
        for (int i = 0; i<3; i++) {
            String temp = scanner.nextLine();
            for (int j = 0; j<3; j++) {
                board[i][j] = temp.charAt(j);
            }
        }
        int ansSingular = 0;
        int ansTeam = 0;
        ArrayList<Character> playerSingular = new ArrayList<>();
        ArrayList<TreeSet> playerTeam = new ArrayList<>();
        for (int i = 0; i<3; i++) {
            if (board[i][0]==board[i][1]&&board[i][1]==board[i][2]&&!playerSingular.contains(board[i][0])) {
                ansSingular++;
                playerSingular.add(board[i][0]);
            }
            if (board[0][i]==board[1][i]&&board[1][i]==board[2][i]&&!playerSingular.contains(board[0][i])) {
                ansSingular++;
                playerSingular.add(board[0][i]);
            }
        }
        if (board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&!playerSingular.contains(board[0][0])) {
            ansSingular++;
            playerSingular.add(board[0][0]);
        }
        if (board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&!playerSingular.contains(board[0][2])) {
            ansSingular++;
            playerSingular.add(board[0][2]);
        }
        TreeSet<Character> tempp = new TreeSet<>();
        for (int i = 0; i<3; i++) {
            tempp.add(board[i][0]);
            tempp.add(board[i][1]);
            tempp.add(board[i][2]);
            if ((board[i][0]==board[i][1]||board[i][1]==board[i][2]||board[i][0]==board[i][2])&&!(board[i][0]==board[i][1]&&board[i][1]==board[i][2]&&board[i][0]==board[i][2])&&!playerTeam.contains(tempp)) {
                ansTeam++;
                playerTeam.add(tempp);
            }
            tempp.remove(board[i][0]);
            tempp.remove(board[i][1]);
            tempp.remove(board[i][2]);
            tempp.add(board[0][i]);
            tempp.add(board[1][i]);
            tempp.add(board[2][i]);
            if (board[0][i]==board[1][i]||board[1][i]==board[2][i]||board[0][i]==board[2][i]&&!(board[0][i]==board[1][i]&&board[1][i]==board[2][i]&&board[0][i]==board[2][i])&&!playerTeam.contains(tempp)) {
                ansTeam++;
                playerTeam.add(tempp);
            }
            tempp.remove(board[0][i]);
            tempp.remove(board[1][i]);
            tempp.remove(board[2][i]);
        }
        tempp.add(board[0][0]);
        tempp.add(board[1][1]);
        tempp.add(board[2][2]);
        if (board[0][0]==board[1][1]||board[1][1]==board[2][2]||board[0][0]==board[2][2]&&!(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[0][0]==board[2][2])&&!playerTeam.contains(tempp)) {
            ansTeam++;
            playerTeam.add(tempp);
        }
        tempp.remove(board[0][0]);
        tempp.remove(board[1][1]);
        tempp.remove(board[2][2]);
        tempp.add(board[0][2]);
        tempp.add(board[1][1]);
        tempp.add(board[2][0]);
        if (board[0][2]==board[1][1]||board[1][1]==board[2][0]||board[0][2]==board[2][0]&&!(board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&board[0][2]==board[2][0])&&!playerTeam.contains(tempp)) {
            ansTeam++;
            playerTeam.add(tempp);
        }
        PrintWriter pw = new PrintWriter("tttt.out");
        pw.println(ansSingular);
        pw.println(ansTeam);
        pw.close();
    }
}
