import java.util.*;

public class programmers체육복 {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            int[] count = new int[n + 1];
            Arrays.fill(count, 1);
            for (int i = 0; i < lost.length; i++) {
                count[lost[i]]--;
            }
            for (int i = 0; i < reserve.length; i++) {
                count[reserve[i]]++;
            }

            for (int i = 1; i <= n; i++) {
                if (count[i] == 0) {
                    if (i - 1 >= 0 && count[i - 1] == 2) {
                        count[i] = 1;
                        count[i - 1] = 1;
                        continue;
                    }
                    if (i + 1 <= n && count[i + 1] == 2) {
                        count[i] = 1;
                        count[i + 1] = 1;
                        continue;
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                if (count[i] >= 1) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
