import java.util.*;

public class programmersN번째원소까지 {
    class Solution {
        public int[] solution(int[] num_list, int n) {
            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                answer.add(num_list[i]);
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
