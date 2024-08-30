import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String input = reader.readLine();
        int sum = 1;
        int answer = 0;
        boolean ok = true;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '(':
                    stack.push(c);
                    sum *= 2;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() == '[') {
                        ok = false;
                        break;
                    }
                    if (input.charAt(i - 1) == '(') {
                        answer += sum;
                    }
                    sum /= 2;
                    stack.pop();
                    break;
                case '[':
                    stack.push(c);
                    sum *= 3;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() == '(') {
                        ok = false;
                        break;
                    }
                    if (input.charAt(i - 1) == '[') {
                        answer += sum;
                    }
                    sum /= 3;
                    stack.pop();
                    break;
            }
        }

        System.out.println(ok && stack.isEmpty() ? answer : 0);
    }
}
