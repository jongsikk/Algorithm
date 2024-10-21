import java.util.*;

public class programmers햄버거만들기 {
    class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < ingredient.length; i++) {
                if (stack.size() == 0) {
                    stack.push(ingredient[i]);
                    continue;
                }
                if (ingredient[i] == 1) {
                    if (stack.size() < 3) {
                        stack.push(ingredient[i]);
                        continue;
                    } else {
                        int meat = stack.pop();
                        int vegetable = stack.pop();
                        int bun = stack.pop();
                        if (meat == 3 && vegetable == 2 && bun == 1) {
                            answer++;
                        } else {
                            stack.push(bun);
                            stack.push(vegetable);
                            stack.push(meat);
                            stack.push(ingredient[i]);
                        }
                    }
                } else {
                    stack.push(ingredient[i]);
                }
            }
            return answer;
        }
    }
}
