public class programmers키패드누르기 {
    class Solution {
        public String solution(int[] numbers, String hand) {
            StringBuilder sb = new StringBuilder();
            // 규칙을 위해 * 0 # -> 10 11 12
            int left = 10;
            int right = 12;
            for (int i = 0; i < numbers.length; i++) {
                int n = numbers[i];
                if (n == 0) {
                    n = 11;
                }
                if (n == 1 || n == 4 || n == 7) {
                    left = n;
                    sb.append("L");
                } else if (n == 3 || n == 6 || n == 9) {
                    right = n;
                    sb.append("R");
                } else {
                    // |현재 위치 - 타겟|을 3으로 나눈 몫과 나머지를 더하면 거리
                    int ldist = Math.abs(n - left) / 3 + Math.abs(n - left) % 3;
                    int rdist = Math.abs(n - right) / 3 + Math.abs(n - right) % 3;
                    if (ldist > rdist || (hand.equals("right") && ldist == rdist)) {
                        right = n;
                        sb.append("R");
                    } else if (ldist < rdist || (hand.equals("left") && ldist == rdist)) {
                        left = n;
                        sb.append("L");
                    }
                }
            }
            return sb.toString();
        }
    }
}
