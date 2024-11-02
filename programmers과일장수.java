import java.util.*;

public class programmers과일장수 {
    class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;
            Queue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
            for (int i = 0; i < score.length; i++) {
                pq.add(score[i]);
            }

            int count = 0;
            while (!pq.isEmpty()) {
                int n = pq.poll();
                count++;
                if (count % m == 0) {
                    answer += (n * m);
                    count = 0;
                }
            }

            return answer;
        }
    }
}
