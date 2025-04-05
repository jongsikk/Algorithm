public class leetcode121_2 {
    class Solution {
        public int maxProfit(int[] prices) {
            int answer = 0;
            int buy = prices[0];
            for (int i = 0; i < prices.length; i++) {
                if (buy > prices[i]) {
                    buy = prices[i];
                }
                answer = Math.max(answer, prices[i] - buy);
            }

            return answer;
        }
    }
}
