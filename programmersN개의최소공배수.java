public class programmersN개의최소공배수 {
    class Solution {
        public int solution(int[] arr) {
            int answer = lcm(arr[0], arr[1]);
            for (int i = 2; i < arr.length; i++) {
                answer = lcm(answer, arr[i]);
            }
            return answer;
        }

        static int gcd(int a, int b) {
            int num = 0;
            for (int i = 1; i <= Math.min(a, b); i++) {
                if (a % i == 0 && b % i == 0) {
                    num = i;
                }
            }
            return num;
        }

        /*
         * 유클리드 호제법
         * a < b 일 때,
         * a = b * q + r
         * gcd(a, b) = gcd(b, r)
         * ex) a = 270, b = 192
         * gcd(270, 192) = gcd(192, 78(270 = 192 * 1 + 78)) ... = gcd(6, 0) = 6
         */
        static int gcd2(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd2(b, a % b);
        }

        static int lcm(int a, int b) {
            return a * b / gcd2(a, b);
        }

    }
}
