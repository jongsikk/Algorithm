public class leetcode191 {
    class Solution {
        public int hammingWeight(int n) {
            int answer = 0;

            for (char c : Integer.toBinaryString(n).toCharArray()) {
                if (c == '1') {
                    answer++;
                }
            }

            return answer;
        }
    }
}
