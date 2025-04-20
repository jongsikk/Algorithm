import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode1046 {
    class Solution {
        public int lastStoneWeight(int[] stones) {
            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i : stones) {
                pq.offer(i);
            }

            while (pq.size() != 1) {
                int a = pq.poll();
                int b = pq.poll();
                pq.offer(Math.abs(a - b));
            }

            return pq.poll();
        }
    }
}
