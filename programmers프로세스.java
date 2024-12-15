import java.util.*;

public class programmers프로세스 {

    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<int[]> queue = new LinkedList<>();
            Queue<Integer> priority = new PriorityQueue<>((i1, i2) -> i2 - i1);

            for (int i = 0; i < priorities.length; i++) {
                queue.offer(new int[] { i, priorities[i] });
                priority.offer(priorities[i]);
            }

            while (!queue.isEmpty()) {
                int[] task = queue.poll();
                int index = task[0];
                int pri = task[1];
                int max = priority.poll();
                if (max != pri) {
                    queue.offer(task);
                    priority.offer(max);
                    continue;
                } else {
                    answer++;
                }
                if (index == location) {
                    break;
                }
            }
            return answer;
        }
    }
}
