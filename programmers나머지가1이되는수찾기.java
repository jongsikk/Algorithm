public class programmers나머지가1이되는수찾기 {
    class Solution {
        public int solution(int n) {
            int answer = 1;
            while (true) {
                if (n % answer == 1) {
                    break;
                }
                answer++;
            }
            return answer;
        }
    }
}
