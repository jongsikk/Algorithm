import java.util.HashMap;
import java.util.Map;

public class leetcode424 {
    class Solution {
        public int characterReplacement(String s, int k) {
            Map<Character, Integer> map = new HashMap<>();
            int answer = 0;
            int start = 0;
            int end = 0;
            int max = 0;
            while (end < s.length()) {
                char c = s.charAt(end);
                map.put(c, map.getOrDefault(c, 0) + 1);
                max = Math.max(max, map.get(c));

                while (end - start + 1 - max > k) {
                    char rm = s.charAt(start);
                    map.put(rm, map.get(rm) - 1);
                    start++;
                }

                answer = Math.max(answer, end - start + 1);
                end++;
            }

            return answer;
        }
    }
}
