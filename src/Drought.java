import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;

public class Drought {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int N = scanner.nextInt();
            Vector<Long> H = new Vector<>();
            for (int i = 0; i < N; i++) {
                H.add(scanner.nextLong());
            }
            System.out.println(solve(H));
        }
    }
    static long solve(Vector<Long> h) {
        int N = h.size();
        AtomicLong ans = new AtomicLong();
        java.util.function.BiConsumer<Integer, Long> operations = (idx, num_op) -> {
            assert num_op >= 0;
            h.set(idx, h.get(idx) - num_op);
            h.set(idx + 1, h.get(idx + 1) - num_op);
            ans.addAndGet(2 * num_op);
        };
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < N; ++i) {
                if (!h.get(i - 1).equals(h.get(i))) {
                    flag = true;
                    if (h.get(i - 1) < h.get(i)) {
                        if (i == N - 1) return -1;
                        operations.accept(i, h.get(i) - h.get(i - 1));
                    } else {
                        if (i == 1) return -1;
                        operations.accept(i - 2, h.get(i - 1) - h.get(i));
                    }
                    break;
                }
            }
        }
        if (h.get(0) < 0) return -1;
        return ans.get();
    }
}
