import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode692 {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            List<String> answer = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();

            for (String s : words) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

            List<String> keys = new ArrayList<>(map.keySet());
            keys.sort((s1, s2) -> {
                if (map.get(s2) == map.get(s1)) {
                    return s1.compareTo(s2);
                }
                return map.get(s2) - map.get(s1);
            });

            int count = 0;
            for (String s : keys) {
                if (count == k) {
                    break;
                }
                answer.add(s);
                count++;
            }

            return answer;
        }
    }
}
