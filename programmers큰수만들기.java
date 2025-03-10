import java.util.*;

public class programmers큰수만들기 {
    class Solution {
        public String solution(String number, int k) {
            Stack<Character> stack = new Stack<>();

            for (char c : number.toCharArray()) {
                while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(c);
            }

            while (!stack.isEmpty() && k-- != 0) {
                stack.pop();
            }

            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }

            return sb.toString();
        }
    }
}
