import java.util.Scanner;

public class AppleDivision {
    public static int[] data;
    public static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        System.out.println(recursion(0,0,0));

    }
    public static long recursion(int i, long set1, long set2) {
        if (i==n){
            return Math.abs(set1-set2);
        } else {
            return Math.min(recursion(i+1,set1+data[i], set2), recursion(i+1,set1,set2+data[i]));
        }
    }
}

