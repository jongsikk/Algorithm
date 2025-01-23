public class programmers연속된부분수열의합 {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = new int[2];
            int len = sequence.length;
            answer[0] = 0;
            answer[1] = Integer.MAX_VALUE;
            int start = 0;
            int end = 0;
            int total = sequence[0];

            while (start <= end && end < len) {
                if (total == k) {
                    if (end - start < answer[1] - answer[0]) {
                        answer[0] = start;
                        answer[1] = end;
                    }
                }
                if (total <= k) {
                    end++;
                    if (end < len)
                        total += sequence[end];
                }
                if (total > k) {
                    if (start < len)
                        total -= sequence[start];
                    start++;
                }
            }

            return answer;
        }
    }
}
