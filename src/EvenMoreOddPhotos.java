import java.util.Scanner;

public class EvenMoreOddPhotos {
    //from the USACO 2021 Jan Contest, Bronze
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
        int count = 0;
        for (int i = 0; i<n; i++) {
            if (i % 2 == 0) {
                if (even >= 1) {
                    even--;
                    count++;
                } else if (odd >= 2) {
                    odd -= 2;
                    count++;
                } else {
                    break;
                }
            } else {
                if (even >= 1 && odd >= 1) {
                    even--;
                    odd--;
                    count++;
                } else if (odd >= 3) {
                    odd -= 3;
                    count++;
                } else if (odd >= 1) {
                    odd--;
                    count++;
                } else {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
