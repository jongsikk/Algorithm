public class leetcode2239 {
    class Solution {
        public int findClosestNumber(int[] nums) {
            int answer = 0;
            int value = Integer.MAX_VALUE;

            for (int i : nums) {
                int abs = Math.abs(0 - i);
                if (abs < value) {
                    value = abs;
                    answer = i;
                } else if (abs == value) {
                    answer = Math.max(answer, i);
                }
            }

            return answer;
        }
    }
}
