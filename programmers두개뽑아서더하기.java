import java.util.*;

public class programmers두개뽑아서더하기 {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    set.add(numbers[i] + numbers[j]);
                }
            }

            answer = new int[set.size()];
            int index = 0;
            for (int i : set) {
                answer[index++] = i;
            }
            Arrays.sort(answer);

            return answer;
        }
    }
}
