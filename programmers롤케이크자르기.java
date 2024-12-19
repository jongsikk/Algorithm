import java.util.*;

public class programmers롤케이크자르기 {
    class Solution {
        public int solution(int[] topping) {
            int answer = 0;
            Map<Integer, Integer> chulsoo = new HashMap<>();
            Map<Integer, Integer> brother = new HashMap<>();
            for (int i : topping) {
                chulsoo.put(i, chulsoo.getOrDefault(i, 0) + 1);
            }

            for (int i = topping.length - 1; i >= 0; i--) {
                int t = topping[i];
                chulsoo.put(t, chulsoo.get(t) - 1);
                brother.put(t, brother.getOrDefault(t, 0) + 1);
                if (chulsoo.get(t) == 0) {
                    chulsoo.remove(t);
                }
                if (chulsoo.size() == brother.size()) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
