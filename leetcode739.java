import java.util.Stack;

public class leetcode739 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] answer = new int[temperatures.length];
            Stack<int[]> stack = new Stack<>();
            for (int i = 0; i < temperatures.length; i++) {
                while (!stack.isEmpty() && temperatures[i] > stack.peek()[1]) {
                    answer[stack.peek()[0]] = i - stack.pop()[0];
                }
                stack.push(new int[] { i, temperatures[i] });
            }

            return answer;
        }
    }
}
