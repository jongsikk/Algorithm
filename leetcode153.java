public class leetcode153 {
    class Solution {
        public int findMin(int[] nums) {
            int start = 0;
            int end = nums.length - 1;

            while (start < end) {
                int mid = (start + end) / 2;

                if (nums[end] > nums[mid]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            return nums[start];
        }
    }
}
