import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Distinct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> data = new HashSet<>();
        for (int i = 0; i<n; i++) {
            data.add(scanner.nextInt());
        }
        System.out.println(data.size());
    }
}
