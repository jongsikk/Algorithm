public class programmers가운데글자가져오기 {
    class Solution {
        public String solution(String s) {
            if (s.length() % 2 == 0) {
                return s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
            } else {
                return s.charAt(s.length() / 2) + "";
            }
        }
    }
}
