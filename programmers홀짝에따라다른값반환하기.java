public class programmers홀짝에따라다른값반환하기 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if (n % 2 != 0 && i % 2 != 0) {
                    answer += i;
                } else if (n % 2 == 0 && i % 2 == 0) {
                    answer += i * i;
                }
            }

            return answer;
        }
    }
}
