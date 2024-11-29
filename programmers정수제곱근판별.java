public class programmers정수제곱근판별 {
    class Solution {
        public long solution(long n) {
            long answer = 0;
            if (Math.pow((long) Math.sqrt(n), 2) == n) {
                answer = (long) Math.pow((long) Math.sqrt(n) + 1, 2);
            }

            return answer == 0 ? -1 : answer;
        }
    }
}
