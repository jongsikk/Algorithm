import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 100001);
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(reader.readLine()));
        }
        dp[0] = 0;
        for (int i : set) {
            for (int j = i; j <= k; j++) {
                dp[j] = Math.min(1 + dp[j - i], dp[j]);
            }
        }
        System.out.println(dp[k] == 100001 ? -1 : dp[k]);
    }
}
