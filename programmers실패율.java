import java.util.*;

public class programmers실패율 {
    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Double> ratio = new HashMap<>();
            int player = stages.length;

            for (int i = 0; i < player; i++) {
                map.put(stages[i], map.getOrDefault(stages[i], 0) + 1);
            }

            for (int i = 0; i < N; i++) {
                int num = map.getOrDefault(i + 1, 0);
                if (player == 0) {
                    ratio.put(i + 1, 0.0);
                } else {
                    ratio.put(i + 1, (double) num / player);
                }
                player -= num;
            }

            List<Integer> stage = new ArrayList<>(ratio.keySet());
            Collections.sort(stage, (s1, s2) -> Double.compare(ratio.get(s2), ratio.get(s1)));
            for (int i = 0; i < stage.size(); i++) {
                answer[i] = stage.get(i);
            }

            return answer;
        }
    }
}
