import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] v = new int[n + 1];
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][s] = true;
        st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= m; j++) {
                if (dp[i - 1][j]) {
                    if (j + v[i] <= m) {
                        dp[i][j + v[i]] = true;
                    }
                    if (j - v[i] >= 0) {
                        dp[i][j - v[i]] = true;
                    }
                }
            }
        }

        int answer = -1;
        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
