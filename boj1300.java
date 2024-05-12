import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1300 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        long min = 1;
        long max = k;

        while (min < max) {
            long mid = (min + max) / 2;
            long count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }
            if (count < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        System.out.println(min);
    }
}
