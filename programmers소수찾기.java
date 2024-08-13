import java.util.*;

public class programmers소수찾기 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            boolean[] result = new boolean[n + 1];
            Arrays.fill(result, true);
            result[0] = false;
            result[1] = false;
            for (int i = 2; i * i <= n; i++) {
                if (result[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        result[j] = false;
                    }
                }
            }
            for (int i = 2; i <= n; i++) {
                if (result[i]) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
