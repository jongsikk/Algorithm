public class programmers머쓱이보다키큰사람 {
    class Solution {
        public int solution(int[] array, int height) {
            int answer = 0;
            for (int i : array) {
                if (i > height) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
