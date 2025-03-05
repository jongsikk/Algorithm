import java.util.Arrays;

public class leetcode268 {
    class Solution {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);
            int start = 0;
            for (int i : nums) {
                if (start == i) {
                    start++;
                } else {
                    break;
                }
            }
            return start;
        }
    }
}
