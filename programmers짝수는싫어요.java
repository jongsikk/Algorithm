import java.util.*;

public class programmers짝수는싫어요 {
    class Solution {
        public int[] solution(int n) {
            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (i % 2 == 1) {
                    answer.add(i);
                }
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
