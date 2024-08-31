public class programmers콜라츠추측 {
    class Solution {
        public int solution(int num) {
            int answer = 0;
            if (num == 1) {
                return answer;
            }
            long num1 = num;
            while (num1 != 1) {
                if (answer > 500) {
                    answer = -1;
                    break;
                }
                if (num1 % 2 == 0) {
                    num1 /= 2;
                } else {
                    num1 = (num1 * 3) + 1;
                }
                answer++;
            }
            return answer;
        }
    }
}
