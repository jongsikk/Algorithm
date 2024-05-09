import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2417 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        long min = 0;
        long max = n;

        while (min <= max) {
            long mid = (min + max) / 2;
            if (Math.pow(mid, 2) >= n) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }

        }
        System.out.println(min);
    }
}
