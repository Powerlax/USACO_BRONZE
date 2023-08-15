import java.util.Scanner;

public class EvenMoreOddPhotos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int odd = 0;
        int even = 0;
        for (int i = 0; i<n; i++) {
            int temp = scanner.nextInt();
            if (temp % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        while (odd > even) {
            odd = odd - 2;
            even++;
        }
        if (even > odd + 1) {
            even = odd + 1;
        }
        System.out.println(even + odd);
    }
}
