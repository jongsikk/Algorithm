public class programmers점프와순간이동 {
    public class Solution {
        /*
         * DP로 풀면 될듯했는데 효율성에서 박살남 (메모리 초과, 시간초과)
         * N이 10억 이하 자연수라서 그런듯
         * 
         * N을 2씩 나눠가다가 나머지가 발생하면 (점프하는 상황) ans++
         */
        public int solution(int n) {
            int ans = 0;
            while (n > 0) {
                if (n % 2 != 0) {
                    ans++;
                }
                n /= 2;
            }

            return ans;
        }

        public int solution1(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i / 2] + i % 2;
            }

            return dp[n];
        }
    }
}
