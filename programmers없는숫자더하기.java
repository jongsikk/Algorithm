import java.util.*;

public class programmers없는숫자더하기 {
    class Solution {
        public int solution(int[] numbers) {
            int answer = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < numbers.length; i++) {
                set.add(numbers[i]);
            }

            for (int i = 0; i < 10; i++) {
                if (!set.contains(i)) {
                    answer += i;
                }
            }

            return answer;
        }
    }
}
