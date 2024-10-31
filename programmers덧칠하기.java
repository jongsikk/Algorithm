public class programmers덧칠하기 {
    class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 0;
            int pos = 0;
            for (int i = 0; i < section.length; i++) {
                if (section[i] <= pos) {
                    continue;
                }
                pos = section[i] + m - 1;
                answer++;
            }

            return answer;
        }
    }
}
