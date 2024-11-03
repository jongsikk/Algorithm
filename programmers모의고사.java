import java.util.*;

public class programmers모의고사 {
    class Solution {
        public int[] solution(int[] answers) {
            List<Integer> answer = new ArrayList<>();
            Map<Integer, Integer> count = new HashMap<>();
            int[] no1 = { 1, 2, 3, 4, 5 };
            int[] no2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
            int[] no3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == no1[i % no1.length]) {
                    count.put(1, count.getOrDefault(1, 0) + 1);
                }
                if (answers[i] == no2[i % no2.length]) {
                    count.put(2, count.getOrDefault(2, 0) + 1);
                }
                if (answers[i] == no3[i % no3.length]) {
                    count.put(3, count.getOrDefault(3, 0) + 1);
                }
            }

            int max = Collections.max(count.values());
            for (int i : count.keySet()) {
                if (max == count.get(i)) {
                    answer.add(i);
                }
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
