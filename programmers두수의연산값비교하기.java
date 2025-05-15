public class programmers두수의연산값비교하기 {
    class Solution {
        public int solution(int a, int b) {
            int answer = Math.max(Integer.parseInt(String.valueOf(a) + String.valueOf(b)), 2 * a * b);

            return answer;
        }
    }
}
