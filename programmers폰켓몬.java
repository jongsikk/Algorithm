import java.util.*;

public class programmers폰켓몬 {
    class Solution {
        public int solution(int[] nums) {
            int size = nums.length;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                set.add(nums[i]);
            }

            return set.size() > size / 2 ? size / 2 : set.size();
        }
    }
}
