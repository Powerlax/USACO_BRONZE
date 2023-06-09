import java.util.Arrays;
import java.util.Scanner;

public class ABCs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = {scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt()};
        Arrays.sort(nums);
        System.out.println(nums[0]+" "+nums[1]+" "+(nums[6]-(nums[0]+nums[1])));
    }
}