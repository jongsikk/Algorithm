import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2193 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] dp = new long[n + 1];
        if (n == 1 || n == 2) {
            System.out.println(1);
        } else {
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            System.out.println(dp[n]);
        }
    }
}
