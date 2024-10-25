import java.util.*;

public class programmers둘만의암호 {
    class Solution {
        public String solution(String s, String skip, int index) {
            StringBuilder sb = new StringBuilder();
            Set<Character> set = new HashSet<>();

            for (int i = 0; i < skip.length(); i++) {
                set.add(skip.charAt(i));
            }

            for (int i = 0; i < s.length(); i++) {
                int count = index;
                char c = s.charAt(i);
                while (count > 0) {
                    c++;
                    if (c > 'z') {
                        c = 'a';
                    }
                    if (!set.contains(c)) {
                        count--;
                    }
                }
                sb.append(c);
            }

            return sb.toString();
        }
    }
}
