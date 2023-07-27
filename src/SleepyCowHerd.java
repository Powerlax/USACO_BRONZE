import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SleepyCowHerd {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("herding.in"));
        int[] data = new int[3];
        for (int i = 0; i<3; i++) {
            data[i] = scanner.nextInt();
        }
        Arrays.sort(data);
        int ans = 0;
        if (data[1] - data[0] == 1 && data[2] - data[1] == 1) {
            ans = 0;
        } else if (data[1] - data[0] == 2 || data[2] - data[1] == 2) {
            ans = 1;
        } else {
            ans = 2;
        }
        PrintWriter pw = new PrintWriter("herding.out");
        pw.println(ans);
        pw.println(Math.max(data[1]-data[0],data[2]-data[1])-1);
        pw.close();
    }
}
