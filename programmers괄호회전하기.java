import java.util.Stack;

class programmers괄호회전하기 {
    public int solution(String s) {
        if (s.length() % 2 == 1) {
            return 0;
        }

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            s = s.substring(1) + s.charAt(0);
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (match(stack.peek(), c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }

        }
        return answer;
    }

    public boolean match(char a, char b) {
        if (a == '[' && b == ']') {
            return true;
        }
        if (a == '{' && b == '}') {
            return true;
        }
        if (a == '(' && b == ')') {
            return true;
        }
        return false;
    }
}