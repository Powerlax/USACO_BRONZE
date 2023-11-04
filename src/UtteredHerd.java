import java.util.Scanner;

public class UtteredHerd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cowlang = scanner.nextLine();
        String heard = scanner.nextLine();
        int count = 1;
        for (int i = 0; i<heard.length()-1; i++) {
            if (cowlang.indexOf(heard.charAt(i + 1)) <= cowlang.indexOf(heard.charAt(i))) count++;
        }
        System.out.println(count);
    }
}
