public class programmers문자열나누기 {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            int xCount = 0;
            int yCount = 0;
            char x = ' ';

            for (int i = 0; i < s.length(); i++) {
                if (x == ' ') {
                    x = s.charAt(i);
                    xCount++;
                    continue;
                }

                if (s.charAt(i) == x) {
                    xCount++;
                } else {
                    yCount++;
                }

                if (xCount == yCount) {
                    answer++;
                    xCount = 0;
                    yCount = 0;
                    x = ' ';
                }
            }

            return x == ' ' ? answer : answer + 1;
        }
    }
}
