import java.util.*;

public class programmers숫자게임 {

    class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;
            Queue<Integer> queueA = new PriorityQueue<>();
            Queue<Integer> queueB = new PriorityQueue<>();
            for (int i = 0; i < A.length; i++) {
                queueA.add(A[i]);
                queueB.add(B[i]);
            }
            while (!queueB.isEmpty()) {
                if (queueA.peek() < queueB.peek()) {
                    answer++;
                    queueA.poll();
                    queueB.poll();
                } else {
                    queueB.poll();
                }
            }
            return answer;
        }
    }
}
