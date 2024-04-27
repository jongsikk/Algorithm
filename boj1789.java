import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1789 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(reader.readLine());
        long count = 0;
        long sum = 0;
        while (sum <= s) {
            count++;
            sum += count;
        }
        System.out.println(count - 1);

    }
}
