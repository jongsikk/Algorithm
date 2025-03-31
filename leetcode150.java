import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode150 {
    class Solution {
        public int evalRPN(String[] tokens) {
            if (tokens.length == 1) {
                return Integer.parseInt(tokens[0]);
            }
            Stack<Integer> stack = new Stack<>();
            List<String> ops = new ArrayList<>();
            ops.add("+");
            ops.add("-");
            ops.add("*");
            ops.add("/");

            for (String s : tokens) {
                if (!ops.contains(s)) {
                    stack.push(Integer.parseInt(s));
                } else {
                    int a = stack.pop();
                    int b = stack.pop();
                    int res = 0;
                    switch (s) {
                        case "+":
                            res = b + a;
                            break;
                        case "-":
                            res = b - a;
                            break;
                        case "*":
                            res = b * a;
                            break;
                        case "/":
                            res = b / a;
                            break;
                    }
                    stack.push(res);
                }
            }
            return stack.pop();
        }
    }
}
