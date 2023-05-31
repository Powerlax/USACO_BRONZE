import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class shell {
    public static void main(String[] args) {
        
        try {
            Scanner scanner = new Scanner(new File("shell.in"));
            int n = scanner.nextInt();
            Steps[] steps = new Steps[n];

            for (int i = 0; i < n; i++) {
                int guess = scanner.nextInt() - 1;
                int swap1 = scanner.nextInt() - 1;
                int swap2 = scanner.nextInt() - 1;
                steps[i] = new Steps(swap1, swap2, guess);
            }
            int max = 0;
            for (int start = 1; start <= 3; start++){
                boolean[] hasPebble = new boolean[4];
                hasPebble[start] = true;
                int numPoints = 0;
                for (int i = 0; i<n; i++) {
                    int a = steps[i].a;
                    int b = steps[i].b;
                    int g = steps[i].guess;
                    boolean temp = hasPebble[a];
                    hasPebble[a] = hasPebble[b];
                    hasPebble[b] = temp;
                    if (hasPebble[g]) {
                        numPoints++;
                    }
                }
                if (numPoints>max){
                    max = numPoints;
                }
            }
            PrintWriter pw = new PrintWriter("shell.out");
            pw.println(max);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Steps {
    public int a,b,guess;
    public Steps(int a, int b, int guess) {
        this.a=a;
        this.b=b;
        this.guess=guess;
    }
}