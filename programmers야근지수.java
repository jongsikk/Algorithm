import java.util.*;

public class programmers야근지수 {
    class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;
            long sum = 0;
            for (int i = 0; i < works.length; i++) {
                sum += works[i];
            }
            if (sum < n) {
                return answer;
            }
            Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1);
            for (int i = 0; i < works.length; i++) {
                queue.add(works[i]);
            }
            while (n != 0) {
                queue.add(queue.poll() - 1);
                n--;
            }
            for (int i : queue) {
                answer += i * i;
            }
            return answer;
        }
    }
}
