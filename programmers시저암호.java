public class programmers시저암호 {
    class Solution {
        public String solution(String s, int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (Character.isAlphabetic(s.charAt(i))) {
                    if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                        if (s.charAt(i) + n > 'z') {
                            sb.append((char) (s.charAt(i) - (26 - n)));
                        } else {
                            sb.append((char) (s.charAt(i) + n));
                        }
                    } else {
                        if (s.charAt(i) + n > 'Z') {
                            sb.append((char) (s.charAt(i) - (26 - n)));
                        } else {
                            sb.append((char) (s.charAt(i) + n));
                        }
                    }
                } else {
                    sb.append(" ");
                }
            }

            return sb.toString();
        }
    }
}
