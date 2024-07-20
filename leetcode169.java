import java.util.Arrays;

public class leetcode169 {
    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            int count = 0;
            int now = nums[0];

            for (int num : nums) {
                if (now == num) {
                    count++;
                } else {
                    count--;
                }
                if (count == 0) {
                    now = num;
                    count++;
                }
            }

            return now;
        }
    }
}
