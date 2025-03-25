import java.util.HashMap;
import java.util.Map;

public class leetcode567 {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }

            Map<Character, Integer> s1Map = new HashMap<>();
            Map<Character, Integer> s2Map = new HashMap<>();

            for (int i = 0; i < s1.length(); i++) {
                s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
                s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
            }

            for (int i = s1.length(); i < s2.length(); i++) {
                if (s1Map.equals(s2Map)) {
                    return true;
                }

                char left = s2.charAt(i - s1.length());
                char right = s2.charAt(i);
                s2Map.put(left, s2Map.get(left) - 1);
                if (s2Map.get(left) == 0) {
                    s2Map.remove(left);
                }
                s2Map.put(right, s2Map.getOrDefault(right, 0) + 1);
            }

            return s1Map.equals(s2Map);
        }
    }
}
