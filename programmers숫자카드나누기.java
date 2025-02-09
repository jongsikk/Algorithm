public class programmers숫자카드나누기 {
    class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            int gcdA = arrayGcd(arrayA);
            int resultA = gcdA;
            for (int i : arrayB) {
                if (i % resultA == 0) {
                    resultA = 0;
                    break;
                }
            }

            int gcdB = arrayGcd(arrayB);
            int resultB = gcdB;
            for (int i : arrayA) {
                if (i % resultB == 0) {
                    resultB = 0;
                    break;
                }
            }

            return Math.max(resultA, resultB);
        }

        public int arrayGcd(int[] array) {
            int gcd = 0;
            if (array.length == 1) {
                gcd = array[0];
            } else {
                gcd = gcd(array[0], array[1]);
                for (int i = 2; i < array.length; i++) {
                    gcd = gcd(gcd, array[i]);
                    if (gcd == 1) {
                        break;
                    }
                }
            }
            return gcd;
        }

        public int gcd(int a, int b) {
            if (a < b) {
                int temp = b;
                b = a;
                a = temp;
            }
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }
    }
}
