public class leetcode80 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int index = 1;
            int[] count = new int[20001];
            count[nums[0] + 10000]++;
            for (int i = 1; i < nums.length; i++) {
                if (count[nums[i] + 10000] < 2) {
                    count[nums[i] + 10000]++;
                    nums[index++] = nums[i];
                }
            }
            return index;
        }
    }
}
