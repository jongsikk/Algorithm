public class programmers대문자와소문자 {
    class Solution {
        public String solution(String my_string) {
            char[] cs = my_string.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char c = cs[i];
                if (Character.isUpperCase(c)) {
                    cs[i] = Character.toLowerCase(c);
                } else {
                    cs[i] = Character.toUpperCase(c);
                }
            }

            return new String(cs);
        }
    }
}
