import java.util.*;

public class programmers같은숫자는싫어 {
    public class Solution {
        public int[] solution(int[] arr) {
            int[] answer;
            Stack<Integer> stack = new Stack<>();
            stack.push(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                if (stack.peek() != arr[i]) {
                    stack.add(arr[i]);
                }
            }

            answer = new int[stack.size()];
            int index = 0;
            for (int i : stack) {
                answer[index++] = i;
            }

            return answer;
            // return stack.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
