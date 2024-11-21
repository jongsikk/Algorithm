public class programmers이상한문자만들기 {
    class Solution {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();
            boolean isUpperCase = true;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    isUpperCase = true;
                    sb.append(c);
                    continue;
                }
                if (isUpperCase) {
                    c = Character.toUpperCase(c);
                    isUpperCase = false;
                } else {
                    c = Character.toLowerCase(c);
                    isUpperCase = true;
                }
                sb.append(c);
            }

            return sb.toString();
        }
    }
}
