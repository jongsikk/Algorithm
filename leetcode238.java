public class leetcode238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] answer = new int[nums.length];
            int mul = 1;

            for (int i = 0; i < nums.length; i++) {
                answer[i] = mul;
                mul *= nums[i];
            }

            mul = 1;
            for (int i = nums.length - 1; i > -1; i--) {
                answer[i] *= mul;
                mul *= nums[i];
            }

            return answer;
        }
    }
}
