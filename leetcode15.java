public class leetcode15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> answer = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = nums.length - 1;
                int k = i + 1;

                while (k < j) {
                    int sum = nums[i] + nums[k] + nums[j];

                    if (sum < 0) {
                        k++;
                    } else if (sum > 0) {
                        j--;
                    } else {
                        answer.add(List.of(nums[i], nums[k], nums[j]));
                        k++;

                        while (nums[k] == nums[k - 1] && k < j) {
                            k++;
                        }
                    }
                }
            }

            return answer;
        }
    }
}
