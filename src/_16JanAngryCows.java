import java.io.*;
import java.util.*;
public class _16JanAngryCows {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("angry.in"));
        int n = scanner.nextInt();
        int[] positions = new int[n];
        for(int i = 0; i < n; i++) {
            positions[i] = scanner.nextInt();
        }
        Arrays.sort(positions);
        int answer = 1;
        for(int start = 0; start < n; start++) {
            int leftExplosion = getExplosionIndex(positions, start, true);
            int rightExplosion = getExplosionIndex(positions, start, false);
            int numExploded = rightExplosion - leftExplosion + 1;
            if(numExploded > answer) {
                answer = numExploded;
            }
        }
        PrintWriter pw = new PrintWriter("angry.out");
        pw.println(answer);
        pw.close();
    }
    static int getExplosionIndex(int[] location, int startIndex, boolean goLeft) {
        int lastIndex = startIndex;
        int currentRadius = 1;
        while(lastIndex > 0 && lastIndex < location.length-1) {
            int direction;
            if(goLeft) {
                direction = -1;
            }
            else {
                direction = 1;
            }
            int nextIndex = lastIndex;
            while(nextIndex + direction >= 0 && nextIndex + direction < location.length && Math.abs(location[nextIndex + direction] - location[lastIndex]) <= currentRadius) {
                nextIndex += direction;
            }
            if(nextIndex == lastIndex) {
                break;
            }
            lastIndex = nextIndex;
            currentRadius++;
        }
        return lastIndex;
    }

}