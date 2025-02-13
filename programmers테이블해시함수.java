import java.util.*;

public class programmers테이블해시함수 {
    class Solution {
        public int solution(int[][] data, int col, int row_begin, int row_end) {
            int answer = 0;
            Arrays.sort(data, (d1, d2) -> {
                if (d1[col - 1] == d2[col - 1]) {
                    return d2[0] - d1[0];
                }
                return d1[col - 1] - d2[col - 1];
            });

            int[] mod = new int[data.length];
            for (int i = row_begin; i <= row_end; i++) {
                int sum = 0;
                for (int j = 0; j < data[0].length; j++) {
                    sum += data[i - 1][j] % i;
                }
                mod[i - 1] = sum;
            }

            for (int i : mod) {
                answer = answer ^ i;
            }

            return answer;
        }
    }
}
