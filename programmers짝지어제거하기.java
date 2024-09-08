import java.util.Stack;

public class programmers짝지어제거하기 {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            int left = 0;
            int right = 0;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (stack.isEmpty()) {
                    stack.push(s.charAt(i));
                } else {
                    char c = stack.peek();
                    if (c == s.charAt(i)) {
                        stack.pop();
                        answer++;
                    } else {
                        stack.push(s.charAt(i));
                    }
                }
            }
            return stack.isEmpty() ? 1 : 0;
        }
    }
}
