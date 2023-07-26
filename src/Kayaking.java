import java.util.Scanner;

public class Kayaking {
    public static int[] data;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        data = new int[(n*2)];
        for (int i = 0; i<(n*2); i++) {
            data[i] = scanner.nextInt();
        }
        System.out.println(data);
    }
}
