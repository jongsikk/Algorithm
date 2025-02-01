public class programmers제곱수판별하기 {
    class Solution {
        public int solution(int n) {
            return Math.sqrt(n) % 1 == 0 ? 1 : 2;
        }
    }
}
