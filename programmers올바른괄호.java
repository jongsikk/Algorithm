import java.util.*;

class programmers올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;
        if (s.charAt(0) == ')') {
            answer = false;
            return answer;
        }
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }
}