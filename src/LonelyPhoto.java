import java.util.Scanner;

public class LonelyPhoto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] cows = scanner.next().toCharArray();
        int ans = 0;
        for (int i=0; i<n; i++) {
            int numOfGs = 0;
            int numOfHs = 0;
            for (int j=i; j<n; j++) {
                if (cows[j] == 'G') {
                    numOfGs++;
                } else {
                    numOfHs++;
                }
                if ((numOfGs+numOfHs)>=3 && (numOfGs==1 || numOfHs==1)) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
