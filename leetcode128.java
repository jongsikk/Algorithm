import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode128 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            int answer = 0;
            Set<Integer> set = new HashSet<>();
            int start = Integer.MAX_VALUE;
            for (int i : nums) {
                start = Math.min(i, start);
                set.add(i);
            }
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);

            int count = 0;
            for (int i : list) {
                if (start == i) {
                    count++;
                    start++;
                } else {
                    answer = Math.max(answer, count);
                    count = 1;
                    start = i + 1;
                }
            }

            return Math.max(answer, count);
        }
    }
}
