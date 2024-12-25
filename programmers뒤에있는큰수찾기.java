import java.util.*;

public class programmers뒤에있는큰수찾기 {
    class Solution {
        /*
         * n * n으로 풀었더니 테스트 케이스 3개가 시간초과남
         * 찾아보니 스택을 사용해서 풀어야한다고 함
         * 
         */
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            for (int i = 1; i < numbers.length; i++) {
                // 현재 인덱스의 numbers 값이 스택의 top의 인덱스보다 크면 조건 성립
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                }
                // 현재 인덱스 push
                stack.push(i);
            }

            // 스택에 남아있는 (조건이 성립하는 수가 없는 경우) 자리에 -1채우기
            while (!stack.isEmpty()) {
                System.out.println(stack.peek());
                answer[stack.pop()] = -1;
            }

            return answer;
        }
    }
}
