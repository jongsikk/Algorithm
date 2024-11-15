import java.util.HashMap;
import java.util.Map;

public class leetcode1 {
    /*
     * topics Array, Hash Table
     */
    class Solution {
        /*
         * brute force
         * 반복문 nums.length * nums.length번
         * ==> O(n^2)
         */
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] { i, j };
                    }
                }
            }
            return new int[2];
        }

        /*
         * hash
         * 삽입 및 조회 O(1)
         * 반복문 nums.length번 돌기 때문에 O(n)
         * ==> O(n)
         */
        public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[] { map.get(target - nums[i]), i };
                }
                map.put(nums[i], i);
            }
            return new int[] {};
        }
    }
}
