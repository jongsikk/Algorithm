import java.util.*;

public class programmers최댓값만들기1 {
    class Solution {
        public int solution(int[] numbers) {
            Arrays.sort(numbers);

            return numbers[numbers.length - 1] * numbers[numbers.length - 2];
        }
    }
}
