import java.util.*;

public class programmers징검다리건너기 {

    class Solution {
        public int solution(int[] stones, int k) {
            int min = Integer.MAX_VALUE;
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < stones.length; i++) {
                while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                    deque.pollFirst(); // 슬라이딩 윈도우 범위 벗어났을때
                }

                while (!deque.isEmpty() && stones[deque.peekLast()] < stones[i]) {
                    deque.pollLast(); // 들어갈 값보다 작은값들 다 뺌
                }

                deque.addLast(i);

                if (i >= k - 1) { // 슬라이딩 윈도우 범위마다 체크
                    min = Math.min(min, stones[deque.peekFirst()]);
                }
            }

            return min;
        }
    }
}
