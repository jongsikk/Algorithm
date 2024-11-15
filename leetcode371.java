public class leetcode371 {
    /*
     * topics Math, Bit Manipulation
     */
    class Solution {
        /*
         * math
         */
        public int getSum(int a, int b) {
            return a + b;
        }

        /*
         * bit
         */
        public int getSum2(int a, int b) {
            while (b != 0) {
                int temp = (a & b) << 1; // & 연산으로 동시에 1인 비트 (Carry가 될 비트)구해서 << 1칸 시프트
                a = a ^ b; // 올림 되지 않는 수 계산
                b = temp;
            }

            return a;
        }
    }
}
