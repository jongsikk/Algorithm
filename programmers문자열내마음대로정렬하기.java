import java.util.*;

public class programmers문자열내마음대로정렬하기 {
    class Solution {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, (s1, s2) -> {
                if (s1.charAt(n) == s2.charAt(n)) {
                    return s1.compareTo(s2);
                }
                return s1.charAt(n) - s2.charAt(n);
            });

            return strings;
        }
    }
}
