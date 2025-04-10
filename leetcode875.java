import java.util.Arrays;

public class leetcode875 {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            Arrays.sort(piles);
            int start = 1;
            int end = piles[piles.length - 1];
            int answer = Integer.MAX_VALUE;

            while (start <= end) {
                int mid = (start + end) / 2;
                long sum = 0;
                for (int i = 0; i < piles.length; i++) {
                    sum += piles[i] % mid == 0 ? piles[i] / mid : piles[i] / mid + 1;
                }
                if (sum > h) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return start;
        }
    }
}
