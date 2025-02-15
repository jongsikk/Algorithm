import java.util.*;

public class programmers디펜스게임 {
    class Solution {
        public int solution(int n, int k, int[] enemy) {
            int answer = 0;
            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < enemy.length; i++) {
                if (n >= enemy[i]) {
                    answer++;
                    pq.offer(enemy[i]);
                    n -= enemy[i];
                } else {
                    if (k > 0) {
                        if (!pq.isEmpty()) {
                            if (pq.peek() > enemy[i]) {
                                n += pq.poll();
                                n -= enemy[i];
                                pq.offer(enemy[i]);
                            }
                        }
                        k--;
                        answer++;
                    } else {
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
