public class programmers다트게임 {
    class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            int sum = 0;
            int last = 0;
            for (int i = 0; i < dartResult.length(); i++) {
                char c = dartResult.charAt(i);
                if (c == '1' && dartResult.charAt(i + 1) == '0') {
                    answer += last;
                    last = sum;
                    sum = 10;
                    i++;
                    continue;
                }
                if (c >= '0' && c <= '9') {
                    answer += last;
                    last = sum;
                    sum = c - '0';
                    continue;
                }

                if (c == 'S') {
                    continue;
                } else if (c == 'D') {
                    sum = sum * sum;
                    continue;
                } else if (c == 'T') {
                    sum = sum * sum * sum;
                    continue;
                }

                if (c == '*') {
                    last *= 2;
                    sum *= 2;
                } else if (c == '#') {
                    sum *= -1;
                }
            }
            return answer + sum + last;
        }
    }
}
