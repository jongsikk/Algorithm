import java.util.*;

public class programmers연속부분수열합의개수 {
    class Solution {
        public int solution(int[] elements) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= elements.length; i++) {
                for (int j = 0; j < elements.length; j++) {
                    int sum = 0;
                    for (int k = 0; k < i; k++) {
                        sum += elements[(j + k) % elements.length];
                    }
                    if (!set.contains(sum)) {
                        set.add(sum);
                    }
                }
            }

            return set.size();
        }
    }

}
