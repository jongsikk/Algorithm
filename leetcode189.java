public class leetcode189 {
    class Solution {
        public void rotate(int[] nums, int k) {
            int[] array = new int[nums.length];
            if (nums.length == 1)
                return;
            if (nums.length < k)
                k %= nums.length;
            for (int i = 0; i < nums.length; i++) {
                if (i >= k) {
                    array[i] = nums[i - k];
                } else {
                    array[i] = nums[nums.length - k + i];
                }
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = array[i];
            }
        }
    }
}
