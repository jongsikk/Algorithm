public class programmers점찍기 {
    class Solution {
        public long solution(int k, int d) {
            long answer = 0;
            // x^2 + y^2 = d^2
            // y^2 = d^2 - x^2
            for (long i = 0; i <= d; i += k) {
                long ld = (long) d;
                int maxY = (int) Math.sqrt(ld * ld - i * i);
                answer += (maxY / k) + 1;
            }

            return answer;
        }
    }
}
