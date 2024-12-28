import java.util.*;

public class programmers더맵게 {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            Queue<Integer> pq = new PriorityQueue<>();
            for (int i : scoville) {
                pq.add(i);
            }

            while (pq.size() >= 2 && pq.peek() < K) {
                int i1 = pq.poll();
                int i2 = pq.poll();
                pq.add(i1 + (i2 * 2));
                answer++;
            }

            return pq.size() < 2 && pq.peek() < K ? -1 : answer;
        }
    }
}
