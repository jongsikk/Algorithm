import java.util.*;

public class programmers3진법뒤집기 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            while (n != 0) {
                stack.push(n % 3);
                n /= 3;
            }

            int exp = 0;
            while (!stack.isEmpty()) {
                answer += stack.pop() * Math.pow(3, exp++);
            }

            return answer;
        }

        /*
         * Integer.toString(n, x), Integer.parseInt(n, x)
         * x진수로 변환가능하다
         */
        public int solution2(int n) {
            StringBuilder nsb = new StringBuilder(Integer.toString(n, 3));
            int answer = Integer.parseInt(nsb.reverse().toString(), 3);

            return answer;
        }
    }
}
