import java.util.*;

public class programmers기능개발 {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> answer = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < progresses.length; i++) {
                q.add(progresses[i]);
            }

            int day = 0;
            int count = 0;
            while (!q.isEmpty()) {
                int pollIndex = progresses.length - q.size();
                day++;
                if (q.peek() + (day * speeds[pollIndex]) >= 100) {
                    while (!q.isEmpty() && q.peek() + (day * speeds[pollIndex]) >= 100) {
                        q.poll();
                        count++;
                        pollIndex++;
                    }
                    answer.add(count);
                    count = 0;
                }
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
