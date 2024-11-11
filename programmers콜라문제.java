public class programmers콜라문제 {
    class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;

            while (n / a > 0) {
                int get = n / a * b;
                answer += get;
                n %= a;
                n += get;
            }

            return answer;
        }
    }
}
