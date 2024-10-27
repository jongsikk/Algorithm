import java.util.*;

public class programmers로또의최고순위와최저수위 {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];
            Map<Integer, Integer> grade = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= 5; i++) {
                grade.put(7 - i, i);
            }
            for (int i = 0; i < win_nums.length; i++) {
                set.add(win_nums[i]);
            }

            int matchCount = 0;
            int zeroCount = 0;
            for (int i = 0; i < lottos.length; i++) {
                if (set.contains(lottos[i])) {
                    matchCount++;
                } else if (lottos[i] == 0) {
                    zeroCount++;
                }
            }

            if (matchCount == 5) {
                answer[0] = 1;
                answer[0] = 1;
            } else {
                answer[0] = grade.getOrDefault(zeroCount + matchCount, 6);
                answer[1] = grade.getOrDefault(matchCount, 6);
            }

            return answer;
        }
    }
}
