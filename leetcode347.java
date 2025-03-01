import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            List<Integer> answer = new ArrayList();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            List<Integer> keys = new ArrayList<>(map.keySet());
            keys.sort((k1, k2) -> {
                return map.get(k2) - map.get(k1);
            });

            for (int i = 0; i < k; i++) {
                answer.add(keys.get(i));
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
