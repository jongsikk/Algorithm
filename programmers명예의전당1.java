import java.util.*;

public class programmers명예의전당1 {
    class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            Queue<Integer> pq = new PriorityQueue<>((i1, i2) -> i1 - i2);

            for (int i = 0; i < score.length; i++) {
                pq.add(score[i]);
                if (pq.size() > k) {
                    while (pq.size() > k) {
                        pq.poll();
                    }
                }
                answer[i] = pq.peek();
            }

            return answer;
        }
    }
}
