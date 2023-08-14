import java.util.Scanner;

public class EvenMoreOddPhotos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        int odd = 0;
        int even = 0;
        for (int i = 0; i<n; i++) {
            data[i] = scanner.nextInt();
            if (data[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
    }
}
