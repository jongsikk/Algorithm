import java.util.HashSet;
import java.util.Set;

public class leetcode3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int answer = 0;

            int start = 0;
            int end = 0;
            while (start <= end && end < s.length()) {
                while (set.contains(s.charAt(end))) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(s.charAt(end));
                answer = Math.max(answer, end - start + 1);
                end++;
            }

            return answer;
        }
    }
}