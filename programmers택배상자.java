import java.util.*;

public class programmers택배상자 {
    class Solution {
        public int solution(int[] order) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();

            int index = 0;
            int num = 1;
            while (num <= order.length) {
                if (num == order[index]) {
                    answer++;
                    index++;
                } else if (!stack.isEmpty() && stack.peek() == order[index]) {
                    stack.pop();
                    answer++;
                    index++;
                    num--;
                } else {
                    stack.push(num);
                }
                num++;
            }

            num--;

            while (!stack.isEmpty()) {
                if (stack.pop() == order[index]) {
                    answer++;
                    index++;
                } else {
                    break;
                }
            }

            return answer;
        }
    }
}