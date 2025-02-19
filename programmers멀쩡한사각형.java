public class programmers멀쩡한사각형 {
    class Solution {
        public long solution(int w, int h) {
            long answer = (long) w * h;
            long gcd = gcd(w, h);
            long minimum = (w / gcd) + (h / gcd) - 1;

            return answer - minimum * gcd;
        }

        public long gcd(int a, int b) {
            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (b == 0) {
                return a;
            }

            return gcd(b, a % b);
        }
    }
}
