public class programmers수박수박수박수박수박수 {
    class Solution {
        public String solution(int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    sb.append("박");
                } else {
                    sb.append("수");
                }
            }
            return sb.toString();
        }

        // String.repeat() 첨봄
        public String solution2(int n) {
            return "수박".repeat(n / 2) + "수".repeat(n % 2);
        }
    }
}
