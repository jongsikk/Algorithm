public class programmers문자열다루기기본 {
    class Solution {
        public boolean solution(String s) {
            boolean answer = true;
            if (s.length() == 4 || s.length() == 6) {
                for (int i = 0; i < s.length(); i++) {
                    if (Character.isAlphabetic(s.charAt(i))) {
                        System.out.println(s.charAt(i));
                        return false;
                    }
                }
            } else {
                return false;
            }

            return answer;
        }
    }
}
