import java.util.ArrayList;
import java.util.Scanner;

public class AssociativeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Long> data = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            int temp = scanner.nextInt();
            if (temp==0) {
                int k = scanner.nextInt();
                data.add(k, scanner.nextLong());
            } else {
                System.out.println(data.get(scanner.nextInt()));
            }
        }
    }
}
