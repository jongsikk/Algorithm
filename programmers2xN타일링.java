public class programmers2xN타일링 {
    class Solution {
        public int solution(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i < n + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007;
            }

            return dp[n];
        }
    }
}
