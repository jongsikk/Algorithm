import java.util.*;

public class programmers문자열내림차순으로배치하기 {
    class Solution {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();
            char[] c = s.toCharArray();
            Arrays.sort(c);
            for (int i = s.length() - 1; i > -1; i--) {
                sb.append(c[i]);
            }

            return sb.toString();
        }
    }
}
