import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15486 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] counsels = new int[n + 1][2];
        int[] dp = new int[n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(reader.readLine());
            int days = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            counsels[i][0] = days;
            counsels[i][1] = money;
        }

        for (int i = 1; i <= n; i++) {
            int days = counsels[i][0];
            int money = counsels[i][1];
            if (i + days - 1 <= n) {
                dp[i + days - 1] = Math.max(dp[i + days - 1], dp[i - 1] + money);
            }
            dp[i] = Math.max(dp[i - 1], dp[i]);
        }

        System.out.println(dp[n]);
    }

}
