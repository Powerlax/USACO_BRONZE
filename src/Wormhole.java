import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Wormhole {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("wormhole.in"));
        int n = scanner.nextInt();
        ArrayList<int[]> data = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            int[] temp = {scanner.nextInt(),scanner.nextInt()};
            data.add(temp);
        }
        System.out.println(data.size());
        int ans = 0;
        for (int i = 0; i< data.size(); i++) {
            for (int j = 0; j< data.size(); j++) {
                if (data.get(i)[1]==data.get(j)[1]&&data.get(i)[0]<data.get(j)[0]) {
                    int[] temp = {data.get(i)[0],data.get(i)[1],data.get(j)[0],data.get(j)[1]};
                    data.remove(i);
                    data.remove(j);
                    ans+=solve(data,temp);
                }
            }
        }
        PrintWriter pw = new PrintWriter("wormhole.out");
        pw.println(ans);
        pw.close();
    }
    public static int solve(ArrayList<int[]> data, int[] temp) {
        int ans = 0;
        for (int i = 0; i<data.size(); i++) {
            if (data.get(i)[1]==temp[3]&&data.get(i)[0]>temp[2]) {
                int[] temp2 = {data.get(i)[0],data.get(i)[1],temp[2],temp[3]};
                data.remove(i);
                ans+=solve(data,temp2);
            }
        }
        return ans;
    }
}
